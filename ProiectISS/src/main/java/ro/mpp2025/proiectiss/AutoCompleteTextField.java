package ro.mpp2025.proiectiss;

import javafx.geometry.Side;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.CustomMenuItem;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;

import java.util.ArrayList;
import java.util.List;

public class AutoCompleteTextField extends TextField {

    private final ContextMenu suggestionsPopup = new ContextMenu();
    private final List<String> entries = new ArrayList<>();

    public AutoCompleteTextField() {
        this.addEventHandler(KeyEvent.KEY_RELEASED, event -> {
            String text = getText();
            if (text.length() < 1) {
                suggestionsPopup.hide();
                return;
            }

            List<String> filtered = entries.stream()
                    .filter(e -> e.toLowerCase().contains(text.toLowerCase()))
                    .toList();

            if (filtered.isEmpty()) {
                suggestionsPopup.hide();
            } else {
                List<CustomMenuItem> items = new ArrayList<>();
                for (String result : filtered) {
                    Label entryLabel = new Label(result);
                    CustomMenuItem item = new CustomMenuItem(entryLabel, true);
                    item.setOnAction(e -> {
                        setText(result);
                        positionCaret(result.length());
                        suggestionsPopup.hide();
                    });
                    items.add(item);
                }
                suggestionsPopup.getItems().setAll(items);
                suggestionsPopup.show(this, Side.BOTTOM, 0, 0);
            }
        });
    }

    public void setSuggestions(List<String> suggestions) {
        entries.clear();
        entries.addAll(suggestions);
    }
}