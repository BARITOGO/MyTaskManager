/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Calendar.swing;

import java.awt.event.MouseEvent;

/**
 *
 * @author RAVEN
 */
public interface DynamicCellListener {

    public void scrollChanged(boolean scrollNext);

    public void mouseSelected(MouseEvent mouse);
}
