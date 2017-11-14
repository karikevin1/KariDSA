/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;

import java.util.Iterator;

/**
 *
 * @author User
 */
public interface AffiliatesRegistrationInteraction<T> extends AffiliatesRegistrationInterface{
    public Iterator<T> getIterator();
}
