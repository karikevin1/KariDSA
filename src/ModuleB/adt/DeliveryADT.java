/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;

import ModuleB.entity.Delivery;

/**
 *
 * @author kevin lim
 */
public class DeliveryADT implements DeliveryInterface{
    private static final ListInterface <Delivery> deliList = new LList();
    
    public ListInterface<Delivery> retrieveList(){
        if(this.deliList.isEmpty()){
            Delivery initializeList1, initializeList2, initializeList3, initializeList4;
            initializeList1= new Delivery("LimKH", 1234,"A01", "pewdiepie", "0162313212", "Delivering");
            initializeList2= new Delivery("LimKW", 1111,"A02", "MsTingTT", "012432434", "Delivering");
            initializeList3= new Delivery("LowSK",3456, "A03", "AhLiao", "01312321213", "Delivering");
            initializeList4= new Delivery("NgWD",9909, "A04", "Kazuma", "015213797", "Delivering");        
            this.deliList.add(initializeList1);
            this.deliList.add(initializeList2);
            this.deliList.add(initializeList3);
            this.deliList.add(initializeList4);
        }
        return this.deliList;  
    }
}
