
package src.view.language;

public interface IMouseReactive {

    default InstructionPanel getSourcePanel() {
        return null;
    }
    
    default String getDestType() {
        return "null";
    }

    default boolean needCursorHand() {
        return true;
    }

    default boolean onRelease(InstructionPanel source) {
        return false;
    }
}