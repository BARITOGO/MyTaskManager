/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package MytaskManager.Calendar.Utils;


import CalendarUI.model.ModelDate;
import java.awt.event.MouseEvent;

/**
 *
 * @author Raven
 */
public interface CalendarSelectedListener {

    public void selected(MouseEvent evt, ModelDate date);
}
