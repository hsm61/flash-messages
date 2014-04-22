package es.sandbox.ui.messages;

import java.io.Serializable;

import es.sandbox.ui.messages.resolver.MessageResolver;
import es.sandbox.ui.messages.store.MessagesStore;


public class MessagesPublisher implements Messages {

   private final MessageResolver messageResolver;
   private final MessagesStore store;


   public MessagesPublisher(MessageResolver messageResolver, MessagesStore store) {
      assertThatMessageResolverIsNotNull(messageResolver);
      assertThatMessagesStoreIsNotNull(store);

      this.messageResolver= messageResolver;
      this.store= store;
   }

   private void assertThatMessageResolverIsNotNull(MessageResolver messageResolver) {
      if (messageResolver == null) {
         throw new NullPointerException("MessageResolver can't be null");
      }
   }

   private void assertThatMessagesStoreIsNotNull(MessagesStore store) {
      if (store == null) {
         throw new NullPointerException("MessagesStore can't be null");
      }
   }

   private String resolveMessage(String code, Serializable... arguments) {
      return this.messageResolver.resolve(code, arguments);
   }

   /*
    * (non-Javadoc)
    * @see es.sandbox.ui.messages.Messages#success(java.lang.String, java.io.Serializable[])
    */
   @Override
   public void success(String code, Serializable... arguments) {
      this.store.success(resolveMessage(code, arguments));
   }

   /*
    * (non-Javadoc)
    * @see es.sandbox.ui.messages.Messages#info(java.lang.String, java.io.Serializable[])
    */
   @Override
   public void info(String code, Serializable... arguments) {
      this.store.info(resolveMessage(code, arguments));
   }

   /*
    * (non-Javadoc)
    * @see es.sandbox.ui.messages.Messages#warning(java.lang.String, java.io.Serializable[])
    */
   @Override
   public void warning(String code, Serializable... arguments) {
      this.store.warning(resolveMessage(code, arguments));
   }

   /*
    * (non-Javadoc)
    * @see es.sandbox.ui.messages.Messages#error(java.lang.String, java.io.Serializable[])
    */
   @Override
   public void error(String code, Serializable... arguments) {
      this.store.error(resolveMessage(code, arguments));
   }

   /*
    * (non-Javadoc)
    * @see es.sandbox.ui.messages.Messages#clear()
    */
   @Override
   public void clear() {
      this.store.clear();
   }

   /*
    * (non-Javadoc)
    * @see es.sandbox.ui.messages.Messages#isEmpty()
    */
   @Override
   public boolean isEmpty() {
      return this.store.isEmpty();
   }


   /*
    * (non-Javadoc)
    * @see java.lang.Object#hashCode()
    */
   @Override
   public int hashCode() {
      return this.store.hashCode();
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#equals(java.lang.Object)
    */
   @Override
   public boolean equals(Object obj) {
      return this.store.equals(obj);
   }

   /*
    * (non-Javadoc)
    * @see java.lang.Object#toString()
    */
   @Override
   public String toString() {
      return this.store.toString();
   }
}
