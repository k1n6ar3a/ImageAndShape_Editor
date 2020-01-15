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

/**
 * <p>Title: ColorValueOutOfRange</p>
 * <p>Description: Exception thrown when a color value is out of range</p>
 * @version $Revision: 1.2 $
 */
public class ColorValueOutOfRange extends Exception 
{
	public ColorValueOutOfRange(String message)
	{
		super(message);
		System.exit(1);
	}
}