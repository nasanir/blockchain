package pers.nasanir.blockchain.net;

public class NetNode {
	private String nodeId;
	private String nodeIp;
	private int distance;
	
	public String getNodeId(){
		return this.nodeId;
	}
	
	public String getNodeIp(){
		return this.nodeIp;
	}
	
	public int getDistance(){
		return this.distance;
	}
	
	public void setNetNode(String nodeId,String nodeIp,int distance){
		this.nodeId=nodeId;
		this.nodeIp=nodeIp;
		this.distance=distance;
	}
	
}
