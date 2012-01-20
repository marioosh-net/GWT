package net.marioosh.gwt.client;

/**
 * Interface to represent the messages contained in resource bundle:
 * 	C:/dev/git/GWT/gwt-start/src/main/resources/net/marioosh/gwt/client/Messages.properties'.
 */
public interface Messages extends com.google.gwt.i18n.client.Messages {
  
  /**
   * Translated "Send".
   * 
   * @return translated "Send"
   */
  @DefaultMessage("Send")
  @Key("sendButton")
  String sendButton();

  /**
   * Translated "Url".
   * 
   * @return translated "Url"
   */
  @DefaultMessage("Url")
  @Key("urlField")
  String urlField();
}
