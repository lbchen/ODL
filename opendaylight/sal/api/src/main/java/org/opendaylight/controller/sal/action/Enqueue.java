package org.opendaylight.controller.sal.action;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author lbc 07/23/13
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class Enqueue extends Action {

	private static final long serialVersionUID = 1L;
	@XmlElement
	private short port;
	@XmlElement
	private int queueid;
	
	public Enqueue() {
		type = ActionType.ENQUEUE;
	}
	public Enqueue(short port,int queueid) {
		type = ActionType.ENQUEUE;
		this.port = port;
		this.queueid = queueid;
	}

	public short getPort() {
		return port;
	}

	public void setPort(short port) {
		this.port = port;
	}

	public int getQueueid() {
		return queueid;
	}

	public void setQueueid(int queueid) {
		this.queueid = queueid;
	}

	@Override
	public String toString() {
		return type + "[" + port + ":" + queueid + "]";
	}

}
