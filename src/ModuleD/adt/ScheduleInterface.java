/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleD.adt;
/**
 *
 * @author Alex Ng
 */
public interface ScheduleInterface<T> {
    public boolean addSchedule(T newSchedule);
//    public boolean addSchedule(int newPosition, T newSchedule);
    public T removeSchedule(int position);
//    public boolean replaceSchedule(int position, T newSchedule);
    public T getSchedule(int position);
    public String getPendingList(int Id);
    public T updateSchedule(int position);
    public int getNumberOfSchedule();
    public boolean isEmpty(); 
//    public boolean clearSchedule();
}
