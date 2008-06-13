/*
 * JBoss, Home of Professional Open Source
 * Copyright 2005, JBoss Inc., and individual contributors as indicated
 * by the @authors tag. See the copyright.txt in the distribution for a
 * full listing of individual contributors.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.jboss.messaging.core.client.impl;

import org.jboss.messaging.core.client.ConnectionParams;

/**
 * @author <a href="ataylor@redhat.com">Andy Taylor</a>
 * @author <a href="mailto:tim.fox@jboss.com">Tim Fox</a>
 */
public class ConnectionParamsImpl implements ConnectionParams
{
   //Constants ---------------------------------------------------------------------------------------
      
   public static final int DEFAULT_PING_INTERVAL = 10000; // in ms
   
   public static final int DEFAULT_PING_TIMEOUT = 5000; // ms
   
   public static final int DEFAULT_BLOCKING_CALL_TIMEOUT = 5000; // in ms
   
   public static final boolean DEFAULT_INVM_DISABLED = false;
   
   public static final boolean DEFAULT_TCP_NODELAY = true;
   
   public static final int DEFAULT_TCP_RECEIVE_BUFFER_SIZE = 32 * 1024; // in bytes
   
   public static final int DEFAULT_TCP_SEND_BUFFER_SIZE = 32 * 1024; // in bytes
   
   public static final boolean DEFAULT_SSL_ENABLED = false;
   
   public static final String REMOTING_SSL_KEYSTORE_PATH_PROPERTY_NAME = "remoting.ssl.keystore.path";
   
   public static final String REMOTING_SSL_KEYSTORE_PASSWORD_PROPERTY_NAME = "remoting.ssl.keystore.password";
   
   public static final String REMOTING_SSL_TRUSTSTORE_PATH_PROPERTY_NAME = "remoting.ssl.truststore.path";
   
   public static final String REMOTING_SSL_TRUSTSTORE_PASSWORD_PROPERTY_NAME = "remoting.ssl.truststore.password";
   
   public static final String REMOTING_ENABLE_SSL_PROPERTY_NAME = "remoting.enable.ssl";
   
   
   
   private static final long serialVersionUID = 1662480686951551534L;
   
   // Attributes -------------------------------------------------------------------------------------
   
   private long blockingCallTimeout = DEFAULT_BLOCKING_CALL_TIMEOUT;
   
   private long pingInterval = DEFAULT_PING_INTERVAL;
   
   private long pingTimeout = DEFAULT_PING_TIMEOUT;
   
   private boolean invmDisabled = DEFAULT_INVM_DISABLED;
   
   private boolean tcpNoDelay = DEFAULT_TCP_NODELAY;
   
   private int tcpReceiveBufferSize = DEFAULT_TCP_RECEIVE_BUFFER_SIZE;
   
   private int tcpSendBufferSize = DEFAULT_TCP_SEND_BUFFER_SIZE;
   
   private boolean sslEnabled = DEFAULT_SSL_ENABLED;
   
   private String keyStorePath;
   
   private String keyStorePassword;
   
   private String trustStorePath;
   
   private String trustStorePassword;
   
   public long getBlockingCallTimeout()
   {
      return blockingCallTimeout;
   }

   public void setBlockingCallTimeout(final long timeout)
   {
      this.blockingCallTimeout = timeout;
   }

   public long getPingInterval()
   {
      return pingInterval;
   }

   public void setPingInterval(final long pingInterval)
   {
      this.pingInterval = pingInterval;
   }

   public long getPingTimeout()
   {
      return pingTimeout;
   }

   public void setPingTimeout(final long pingTimeout)
   {
      this.pingTimeout = pingTimeout;
   }

   public boolean isInvmDisabled()
   {
      return invmDisabled;
   }

   public void setInvmDisabled(final boolean invmDisabled)
   {
      this.invmDisabled = invmDisabled;
   }

   public boolean isTcpNoDelay()
   {
      return tcpNoDelay;
   }

   public void setTcpNoDelay(final boolean tcpNoDelay)
   {
      this.tcpNoDelay = tcpNoDelay;
   }

   public int getTcpReceiveBufferSize()
   {
      return tcpReceiveBufferSize;
   }

   public void setTcpReceiveBufferSize(final int tcpReceiveBufferSize)
   {
      this.tcpReceiveBufferSize = tcpReceiveBufferSize;
   }

   public int getTcpSendBufferSize()
   {
      return tcpSendBufferSize;
   }

   public void setTcpSendBufferSize(final int tcpSendBufferSize)
   {
      this.tcpSendBufferSize = tcpSendBufferSize;
   }

   public boolean isSSLEnabled()
   {
      String sslEnabledProperty = System.getProperty(REMOTING_ENABLE_SSL_PROPERTY_NAME);
      
      return sslEnabledProperty == null ? sslEnabled : sslEnabledProperty.equalsIgnoreCase("true");
   }

   public void setSSLEnabled(final boolean sslEnabled)
   {
      this.sslEnabled = sslEnabled;
   }

   public String getKeyStorePath()
   {
      String sslKeystorePath = System.getProperty(REMOTING_SSL_KEYSTORE_PATH_PROPERTY_NAME);
      
      return sslKeystorePath == null ? keyStorePath : sslKeystorePath;
   }

   public void setKeyStorePath(final String keyStorePath)
   {
      this.keyStorePath = keyStorePath;
   }

   public String getKeyStorePassword()
   {
      String keyStorePass = System.getProperty(REMOTING_SSL_KEYSTORE_PASSWORD_PROPERTY_NAME);
      
      return keyStorePass == null ? keyStorePassword : keyStorePass;
   }

   public void setKeyStorePassword(final String keyStorePassword)
   {
      this.keyStorePassword = keyStorePassword;
   }

   public String getTrustStorePath()
   {
      String sslTruststorePath = System.getProperty(REMOTING_SSL_TRUSTSTORE_PATH_PROPERTY_NAME);
      
      return sslTruststorePath == null ? trustStorePath : sslTruststorePath;
   }

   public void setTrustStorePath(final String trustStorePath)
   {
      this.trustStorePath = trustStorePath;
   }

   public String getTrustStorePassword()
   {
      String trustStorePass = System.getProperty(REMOTING_SSL_TRUSTSTORE_PASSWORD_PROPERTY_NAME);
      
      return trustStorePass == null ? trustStorePassword : trustStorePass;
   }

   public void setTrustStorePassword(final String trustStorePassword)
   {
      this.trustStorePassword = trustStorePassword;
   }
     
   public String getURI()
   {
      StringBuffer buff = new StringBuffer();
      buff.append("?").append("blockingCallTimeout=").append(blockingCallTimeout);
      buff.append("&").append("pingInterval=").append(pingInterval);
      buff.append("&").append("pingTimeout=").append(pingTimeout);
      buff.append("&").append("invmDisabled=").append(invmDisabled);
      buff.append("&").append("tcpNoDelay=").append(tcpNoDelay);
      buff.append("&").append("tcpReceiveBufferSize=").append(tcpReceiveBufferSize);
      buff.append("&").append("tcpSendBufferSize=").append(tcpSendBufferSize);
      buff.append("&").append("sslEnabled=").append(sslEnabled);
      buff.append("&").append("keyStorePath=").append(keyStorePath);
      buff.append("&").append("trustStorePath=").append(trustStorePath);
      return buff.toString();
   }
   
   public String toString()
   {
      return "ConnectionParamsImpl:" + System.identityHashCode(this) + ":" + getURI();
   }
   
   public boolean equals(Object other)
   {
      if (other instanceof ConnectionParams == false)
      {
         return false;
      }
      
      ConnectionParams cp = (ConnectionParams)other;
      
      return cp.getBlockingCallTimeout() == blockingCallTimeout &&
             cp.getPingTimeout() == this.pingTimeout &&
             cp.getPingInterval() == this.pingInterval &&
             cp.isInvmDisabled() == this.isInvmDisabled() &&
             cp.isTcpNoDelay() == this.isTcpNoDelay() &&
             cp.getTcpReceiveBufferSize() == this.getTcpReceiveBufferSize() &&
             cp.getTcpSendBufferSize() == this.getTcpSendBufferSize() &&
             cp.isSSLEnabled() == this.isSSLEnabled();
   }
}
