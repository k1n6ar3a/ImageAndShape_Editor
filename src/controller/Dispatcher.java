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

package controller;
import java.awt.event.*;

/**
 * <p>Title: Dispatcher</p>
 * <p>Description: Class that dispatches to the controller events generated by the MouseListener and the MouseMotionListener</p>
 * @version $Revision: 1.8 $
 */
public class Dispatcher implements MouseListener,MouseMotionListener,KeyListener {
	private AbstractTransformer currentTransformer;
	private TransformersIndex transformersIndex;

	/**
	 * Default constructor
	 */
	public Dispatcher() {
		transformersIndex = new TransformersIndex();
		currentTransformer = transformersIndex.getTheDefaultTransformer();
	}

	/**
	 * Mouse clicked event management method
	 * @param e mouse event generated by the system
	 */
	public void mouseClicked(MouseEvent e){
		if(!currentTransformer.mouseClicked(e)){
			AbstractTransformer newTransformer = transformersIndex.getTheAppropriateTransformer(e, currentTransformer);
			if (newTransformer != null) {
				currentTransformer = newTransformer; 
				currentTransformer.mouseClicked(e);
			}
		}
	}

	/**
	 * Mouse pressed event management method
	 * @param e mouse event generated by the system
	 */
	public void mousePressed(MouseEvent e){
		if(!currentTransformer.mousePressed(e)){
			AbstractTransformer newTransformer = transformersIndex.getTheAppropriateTransformer(e, currentTransformer);
			if (newTransformer != null) {
				currentTransformer = newTransformer; 
				currentTransformer.mousePressed(e);
			}
		}
	}

	/**
	 * Mouse released event management method
	 * @param e mouse event generated by the system
	 */
	public void mouseReleased(MouseEvent e){
		if(!currentTransformer.mouseReleased(e)){
			AbstractTransformer newTransformer = transformersIndex.getTheAppropriateTransformer(e, currentTransformer);
			if (newTransformer != null) {
				currentTransformer = newTransformer; 
				currentTransformer.mouseReleased(e);
			}
		}
	}

	/**
	 * Mouse exited event management method
	 * @param e mouse event generated by the system
	 */
	public void mouseExited(MouseEvent e){
	}

	/**
	 * Mouse entered event management method
	 * @param e mouse event generated by the system
	 */
	public void mouseEntered(MouseEvent e){
	}

	/**
	 * Mouse dragged event management method
	 * @param e mouse event generated by the system
	 */
	public void mouseDragged(MouseEvent e){
		if(!currentTransformer.mouseDragged(e)){
			AbstractTransformer newTransformer = transformersIndex.getTheAppropriateTransformer(e, currentTransformer);
			if (newTransformer != null) {
				currentTransformer = newTransformer; 
				currentTransformer.mouseDragged(e);
			}
		}
	}

	/**
	 * Mouse moved event management method
	 * @param e mouse event generated by the system
	 */
	public void mouseMoved(MouseEvent e){
	}
	
	/**
	 * Key pressed event management method
	 * @param e key event generated by the system
	 */
	public void keyPressed(KeyEvent e) {
	}

	/**
	 * Key released event management method
	 * @param e mouse event generated by the system
	 */
	public void keyReleased(KeyEvent e) {
	}
	
	/**
	 * Key typed event management method
	 * @param e mouse event generated by the system
	 */	
	public void keyTyped(KeyEvent e) {
	}
	
	/**
	 * @return
	 */
	public TransformersIndex getTransformersIndex() {
		return transformersIndex;
	}
	
	/**
	 * 
	 * @param t
	 */
	public void setTheCurrentTransformer(AbstractTransformer t) {
		currentTransformer = t;
	}
}