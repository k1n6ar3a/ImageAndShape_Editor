/*
   This file is part of j2dcg.
   j2dcg is free software; you can redistribute it and/or modify
   it under the terms of the GNU General Public License as published by
   the Free Software Foundation; either version 2 of the License, or
   (at your option) any later version.
   j2dcg is distributed in the hope that it will be useful,
   but WITHOUT ANY WARRANTY; without even the implied warranty of
   MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
   GNU General Public License for more details.
   You should have received a copy of the GNU General Public License
   along with j2dcg; if not, write to the Free Software
   Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA  02111-1307  USA
*/
package transformation;

import java.awt.Point;
import java.awt.geom.AffineTransform;
import java.util.Iterator;
import java.util.List;

import controller.AnchoredTransformationCommand;
import controller.MementoTracker;
import model.Shape;

/**
 * <p>Title: RotateCommand</p>
 * <p>Description: </p>
 * @version $Revision: 1.2 $
 */
public class RotateCommand extends AnchoredTransformationCommand {

	/**
	 * @param thetaDegrees the angle of (counter-clockwise) rotation in degrees
	 * @param anchor one of the predefined positions for the anchor point
	 */
	public RotateCommand(double thetaDegrees,
						 int anchor,
						 List aObjects) {
		super(anchor);
		this.thetaDegrees = thetaDegrees;
		objects = aObjects;
	}
	
	/* (non-Javadoc)
	 * @see controller.Command#execute()
	 */
	public void execute() {
		System.out.println("command: rotate " + thetaDegrees +
                           " degrees around " + getAnchor() + ".");

		//R�cupr�ration du point d'ancrage
		Point point = this.getAnchorPoint(objects);
		Iterator iter = objects.iterator();
		Shape shape;
		while(iter.hasNext()){
			shape = (Shape)iter.next();
			mt.addMememto(shape);
			AffineTransform t = shape.getAffineTransform();
			
			//Translation au point relatif (choisi)
			t.translate(point.getX(), point.getY());
			//Rotation
			t.rotate(-1 * thetaDegrees * Math.PI/180);
			//Translation du point relatif choisi � son point initial
			t.translate(-point.getX(), -point.getY());
			
			shape.setAffineTransform(t);
		}
	}

	/* (non-Javadoc)
	 * @see controller.Command#undo()
	 */
	public void undo() {
		mt.setBackMementos();
	}

	private MementoTracker mt = new MementoTracker();
	private List objects;
	private double thetaDegrees;
	
}