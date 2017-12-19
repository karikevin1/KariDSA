/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB;

/**
 *
 * @author kevin lim
 */
public class ComboBoxObj {
    private String indexName;
    private int value;

    public ComboBoxObj() {
    }

    
    public ComboBoxObj(String indexName, int value) {
        this.indexName = indexName;
        this.value = value;
    }

    public String getIndexName() {
        return indexName;
    }

    public void setIndexName(String indexName) {
        this.indexName = indexName;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return indexName;
    }
    
    
}
