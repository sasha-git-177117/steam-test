package customelements;

import aquality.selenium.core.elements.ElementState;
import aquality.selenium.elements.Element;
import consts.CustomTypes;
import org.openqa.selenium.By;

public class Table extends Element {
    protected Table(By loc, String nameOf, ElementState stateOf) {
        super(loc, nameOf, stateOf);
    }

    @Override
    protected String getElementType() {
        return CustomTypes.TABLE.label;
    }
}
