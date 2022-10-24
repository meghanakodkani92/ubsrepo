package hackerrank;

import java.util.HashMap;
import java.util.Map;

public class FurnitureOrder implements FurnitureOrderInterface {
    /**
     * TODO: Create a map of Furniture items to order quantities
     */
    public HashMap<Furniture,Integer> furnitureMap;

    /**
     * Initialize a new mapping of Furniture types to order quantities.
     */

    FurnitureOrder() {
        // TODO: Complete the constructor
        furnitureMap = new HashMap<Furniture,Integer>();
    }

    public void addToOrder(final Furniture type, final int furnitureCount) {
        // TODO: Complete the method
        furnitureMap.put(type,furnitureCount);
    }

    public HashMap<Furniture, Integer> getOrderedFurniture() {
        // TODO: Complete the method
        return furnitureMap;
    }

    public float getTotalOrderCost() {
        // TODO: Complete the method
        float totalCost = 0.0f;
        for(Map.Entry<Furniture,Integer> map : furnitureMap.entrySet()){
            Furniture furniture = map.getKey();
            totalCost = totalCost + (furniture.cost() * map.getValue());
        }

        return totalCost;
    }

    public int getTypeCount(Furniture type) {
        // TODO: Complete the method
        int typeCount = 0;
        for(Map.Entry<Furniture,Integer> map : furnitureMap.entrySet()){
            if(map.getKey().label().equals(type.label())){
                typeCount = typeCount + map.getValue();
            }
        }
        return typeCount;
    }

    public float getTypeCost(Furniture type) {
        // TODO: Complete the method
        float cost = 0.0f;
        for(Map.Entry<Furniture,Integer> map: furnitureMap.entrySet()){
            if(map.getKey().label().equals(type.label())){
                cost = map.getKey().cost() * map.getValue();
                break;
            }
        }
        return cost;
    }

    public int getTotalOrderQuantity() {
        // TODO: Complete the method
        return furnitureMap.values().stream().reduce(0,(a,b) -> (a+b));
    }
}