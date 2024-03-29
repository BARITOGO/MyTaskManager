/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CalendarUI.calendar;

import com.formdev.flatlaf.FlatClientProperties;
import Calendar.Utils.CalendarCellListener;
import Calendar.Utils.CellRenderCustom;
import Calendar.Model.ModelMonth;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.geom.Rectangle2D;
import javax.swing.SwingUtilities;
import Calendar.swing.DynamicCell;
import Calendar.swing.DynamicCellListener;
import java.awt.Rectangle;
/**
 *
 * @author Raven
 */
public class PanelMonth extends DynamicCell<ModelMonth> {

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
        init(new ModelMonth(year - 1, 9));
    }

    private final Point mouse = new Point();
    private int year;
    private CalendarCellListener calendarCellListener;

    public PanelMonth() {
        init();
    }

    private void init() {
        putClientProperty(FlatClientProperties.STYLE, ""
                + "background:if($Calendar.background,$Calendar.background,$Panel.background)");
        setColumn(4);
        setRow(5);
        MouseAdapter mouseAdapter = new MouseAdapter() {
            @Override
            public void mouseMoved(MouseEvent e) {
                mouse.setLocation(e.getPoint());
                repaint();
            }

            @Override
            public void mouseDragged(MouseEvent e) {
                mouse.setLocation(e.getPoint());
                repaint();
            }
        };
        DynamicCellListener dynamicCellListener = new DynamicCellListener() {
            @Override
            public void scrollChanged(boolean scrollNext) {
                calendarCellListener.scrollChanged();
            }

            @Override
            public void mouseSelected(MouseEvent mouse) {
                if (SwingUtilities.isLeftMouseButton(mouse)) {
                    calendarCellListener.cellSelected(mouse, getSelectedIndex());
                }
            }
        };
        addEventDynamicCellListenter(dynamicCellListener);
        addMouseMotionListener(mouseAdapter);
        setDynamicCellRender(new CellRenderCustom<ModelMonth>(mouse) {
            @Override
            public void paintCell(Graphics2D g2, Rectangle2D rectangle, ModelMonth e) {
                FontMetrics fm = g2.getFontMetrics();
                String text = MONTH[e.getMonth() - 1];
                Rectangle2D fr = fm.getStringBounds(text, g2);
                float x = (float) ((rectangle.getWidth() - fr.getWidth()) / 2f);
                float y = (float) (((rectangle.getHeight() - fr.getHeight()) / 2) + fm.getAscent());
                if (e.getYear() == year) {
                    g2.setColor(getForeground());
                } else {
                    g2.setColor(convertColor(getForeground(), 0.3f));
                }
                g2.drawString(text, x, y);
            }

            @Override
            public ModelMonth next(ModelMonth last) {
                int index = (getModels().size() - 1) / 2;
                index += 1;
                if (index < getModels().size()) {
                    year = getModels().get(index).getYear();
                }
                if (last.getMonth() == 12) {
                    return new ModelMonth(last.getYear() + 1, 1);
                } else {
                    return new ModelMonth(last.getYear(), last.getMonth() + 1);
                }
            }

            @Override
            public ModelMonth previous(ModelMonth first) {
                int index = (getModels().size() - 1) / 2;
                index -= 1;
                if (index < getModels().size()) {
                    year = getModels().get(index).getYear();
                }
                if (first.getMonth() == 1) {
                    return new ModelMonth(first.getYear() - 1, 12);
                } else {
                    return new ModelMonth(first.getYear(), first.getMonth() - 1);
                }
            }

            @Override
            public void paintBackground(Graphics2D g2, DynamicCell<ModelMonth> dynamicCell, Rectangle rectangle) {
                throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
            }
        });

    }
    public static final String MONTH[] = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};

    public CalendarCellListener getCalendarCellListener() {
        return calendarCellListener;
    }

    public void setCalendarCellListener(CalendarCellListener calendarCellListener) {
        this.calendarCellListener = calendarCellListener;
    }
}
