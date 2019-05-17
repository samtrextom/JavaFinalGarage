package midtermjavatwo;

/**
 * this interface is the factory for the different menu types of the garage
 */
public interface PrintMenu {

    /**
     * takes in a String that contains the name of the menu type
     * and returns an object of that MenuType
     * @param menuType
     * @return MenuType object
     */
    MenuType getMenuType(String menuType);

}
