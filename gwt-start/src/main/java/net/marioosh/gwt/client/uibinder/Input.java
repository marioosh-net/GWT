package net.marioosh.gwt.client.uibinder;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.HasText;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.TextBox;
import com.google.gwt.user.client.ui.Widget;

public class Input extends Composite {

	private static InputUiBinder uiBinder = GWT.create(InputUiBinder.class);

	interface InputUiBinder extends UiBinder<Widget, Input> {
	}

	@UiField
	Label label;
	
	@UiField
	TextBox input;

	public Input(String label) {
		initWidget(uiBinder.createAndBindUi(this));
	}

	public void setLabel(String label) {
		this.label.setText(label);
	}

	public String getLabel() {
		return label.getText();
	}

}
