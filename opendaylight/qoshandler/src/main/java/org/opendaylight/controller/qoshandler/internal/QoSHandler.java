package org.opendaylight.controller.qoshandler.internal;

import org.opendaylight.controller.sal.core.NodeConnector;
import org.opendaylight.controller.sal.packet.IDataPacketService;
import org.opendaylight.controller.sal.packet.IListenDataPacket;
import org.opendaylight.controller.sal.packet.IPluginOutDataPacketService;
import org.opendaylight.controller.sal.packet.IPv4;
import org.opendaylight.controller.sal.packet.PacketResult;
import org.opendaylight.controller.sal.packet.RawPacket;

public class QoSHandler implements IPluginOutDataPacketService,
		IListenDataPacket {

	private IDataPacketService dataPacketService = null;

	@Override
	public PacketResult receiveDataPacket(RawPacket inPkt) {
		NodeConnector inport = inPkt.getIncomingNodeConnector();
		RawPacket outPkt = null;
		IPv4 ipv4 = new IPv4();
		ipv4.setDiffServ((byte) 4);
		outPkt = this.dataPacketService.encodeDataPacket(ipv4);
		outPkt.setOutgoingNodeConnector(inport);
		this.dataPacketService.transmitDataPacket(outPkt);
		// outPkt.setOutgoingNodeConnector(outgoingNodeConnector);
		return null;
	}

	void setDataPacketService(IDataPacketService s) {
		this.dataPacketService = s;
	}

	void unsetDataPacketService(IDataPacketService s) {
		if (this.dataPacketService == s) {
			this.dataPacketService = null;
		}
	}
}