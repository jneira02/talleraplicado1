/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universidad de La Frontera
 * License Type: Academic
 */
package orm;

import org.orm.*;

public class ConsumoSetCollection extends org.orm.util.ORMSet {
	public ConsumoSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int targetKey, int collType) {
		super(owner, adapter, ownerKey, targetKey, true, collType);
	}
	
	public ConsumoSetCollection(Object owner, org.orm.util.ORMAdapter adapter, int ownerKey, int collType) {
		super(owner, adapter, ownerKey, -1, false, collType);
	}
	
	/**
	* Return an iterator over the persistent objects
	* @return The persisten objects iterator
	*/
	public java.util.Iterator getIterator() {
		return super.getIterator(_ownerAdapter);
	}
	
	/**
	 * Add the specified persistent object to ORMSet
	 * @param value the persistent object
	 */
	public void add(Consumo value) {
		if (value != null) {
			super.add(value, value._ormAdapter);
		}
	}
	
	/**
	 * Remove the specified persistent object from ORMSet
	 * @param value the persistent object
	 */
	public void remove(Consumo value) {
		super.remove(value, value._ormAdapter);
	}
	
	/**
	 * Return true if ORMSet contains the specified persistent object
	 * @param value the persistent object
	 * @return True if this contains the specified persistent object
	 */
	public boolean contains(Consumo value) {
		return super.contains(value);
	}
	
	/**
	 * Return an array containing all of the persistent objects in ORMSet
	 * @return The persistent objects array
	 */
	public Consumo[] toArray() {
		return (Consumo[]) super.toArray(new Consumo[size()]);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id_consumo</li>
	 * <li>tipo_servicio</li>
	 * <li>unidad_servicio</li>
	 * <li>monto_unidad</li>
	 * <li>cantidad_unidades</li>
	 * <li>monto_total</li>
	 * <li>esta_pagado</li>
	 * <li>fecha_vencimiento</li>
	 * <li>id_cliente</li>
	 * <li>monto_fijo</li>
	 * </ul>
	 * @return The persistent objects sorted array
	 */
	public Consumo[] toArray(String propertyName) {
		return toArray(propertyName, true);
	}
	
	/**
	 * Return an sorted array containing all of the persistent objects in ORMSet
	 * @param propertyName Name of the property for sorting:<ul>
	 * <li>id_consumo</li>
	 * <li>tipo_servicio</li>
	 * <li>unidad_servicio</li>
	 * <li>monto_unidad</li>
	 * <li>cantidad_unidades</li>
	 * <li>monto_total</li>
	 * <li>esta_pagado</li>
	 * <li>fecha_vencimiento</li>
	 * <li>id_cliente</li>
	 * <li>monto_fijo</li>
	 * </ul>
	 * @param ascending true for ascending, false for descending
	 * @return The persistent objects sorted array
	 */
	public Consumo[] toArray(String propertyName, boolean ascending) {
		return (Consumo[]) super.toArray(new Consumo[size()], propertyName, ascending);
	}
	
	protected PersistentManager getPersistentManager() throws PersistentException {
		return orm.BDtalleraplicadoPersistentManager.instance();
	}
	
}

