package de.htwg.cityyanderecarcassonne.model;

import de.htwg.cityyanderecarcassonne.model.graph.*;

public class Card {

	private Point leftTopOne;
	private Point middleTop;
	private Point rightTopOne;
	
	private Point leftTopTwo;
	private Point rightTopTwo;
	
	private Point leftCenter;
	private Point middleCenter;
	private Point rightCenter;
	
	private Point leftBelowTwo;
	private Point rightBelowTwo;
	
	private Point leftBelowOne;
	private Point middleBelow;
	private Point rightBelowOne;
    
	private Graph<Point> cardGraph;

    public Card()	{ 
       
    	leftTopOne = new Point(null);
        cardGraph.addVertex(leftTopOne);
        middleTop = new Point(null);
        cardGraph.addVertex(middleTop);
        rightTopOne = new Point(null);
        cardGraph.addVertex(rightTopOne);
        
        leftTopTwo = new Point(null);
        cardGraph.addVertex(leftTopTwo);
        rightTopTwo = new Point(null);
        cardGraph.addVertex(rightTopTwo);
        
        leftCenter = new Point(null);
        cardGraph.addVertex(leftCenter);
        middleCenter = new Point(null);
        cardGraph.addVertex(middleCenter);
        rightCenter = new Point(null);
        cardGraph.addVertex(rightCenter);
        
        leftBelowTwo = new Point(null);
        cardGraph.addVertex(leftBelowTwo);
        rightBelowTwo = new Point(null);
        cardGraph.addVertex(rightBelowTwo);
        
        leftBelowOne = new Point(null);
        cardGraph.addVertex(leftBelowOne);
        middleBelow = new Point(null);
        cardGraph.addVertex(middleBelow);
        rightBelowOne = new Point(null);
        cardGraph.addVertex(rightBelowOne);
        
        cardGraph.addEdge(leftTopTwo, leftTopOne);
        cardGraph.addEdge(rightTopTwo, rightTopOne);
        cardGraph.addEdge(leftBelowTwo, leftBelowOne);
        cardGraph.addEdge(rightBelowTwo, rightBelowOne);
        
        cardGraph.addEdge(leftTopOne, middleTop);
        cardGraph.addEdge(middleTop, rightTopOne);
        
        cardGraph.addEdge(leftCenter, middleCenter);
        cardGraph.addEdge(middleCenter, rightCenter);
        
        cardGraph.addEdge(leftBelowOne, middleBelow);
        cardGraph.addEdge(middleBelow, rightBelowOne);
        
        cardGraph.addEdge(leftTopTwo, middleCenter);
        cardGraph.addEdge(middleCenter, leftBelowTwo);
        
        cardGraph.addEdge(middleTop, middleCenter);
        cardGraph.addEdge(middleCenter, middleBelow);
        
        cardGraph.addEdge(rightTopTwo, rightCenter);
        cardGraph.addEdge(rightCenter, rightBelowTwo);
        
        cardGraph.addEdge(leftTopOne, leftBelowOne);
        cardGraph.addEdge(rightTopOne, rightBelowOne);
        
        cardGraph.addEdge(leftTopTwo, rightTopTwo);
        cardGraph.addEdge(leftBelowTwo, rightBelowTwo);
        
    }
    
    public void setLeftTopOne(String type){
    	this.leftTopOne.setTypeName(type);
    }

    public int getLeftTopOneID()	{
    	return this.leftTopOne.getTypeID();
    }

    public String getLeftTopOneName(){
    	return this.leftTopOne.getTypeName();
    }

    public void setMiddleTop(String type){
    	this.middleTop.setTypeName(type);
    }

    public int getMiddleTopID()	{
    	return this.middleTop.getTypeID();
    }

    public String getMiddleTopName(){
    	return this.middleTop.getTypeName();
    }
    
    public void setRightTopOne(String type){
    	this.rightTopOne.setTypeName(type);
    }

    public int getRightTopOneID()	{
    	return this.rightTopOne.getTypeID();
    }

    public String getRightTopOneName(){
    	return this.rightTopOne.getTypeName();
    }
    
    
    
    public void setLeftTopTwo(String type){
    	this.leftTopTwo.setTypeName(type);
    }

    public int getLeftTopTwoID()	{
    	return this.leftTopTwo.getTypeID();
    }

    public String getLeftTopTwoName(){
    	return this.leftTopTwo.getTypeName();
    }
    
    public void setRightTopTwo(String type){
    	this.rightTopTwo.setTypeName(type);
    }

    public int getRightTopTwoID()	{
    	return this.rightTopTwo.getTypeID();
    }

    public String getRightTopTwoName(){
    	return this.rightTopTwo.getTypeName();
    }
    
    
    
    public void setLeftCenter(String type){
    	this.leftCenter.setTypeName(type);
    }

    public int getLeftCenterID()	{
    	return this.leftCenter.getTypeID();
    }

    public String getLeftCenterName(){
    	return this.leftCenter.getTypeName();
    }

    public void setMiddleCenter(String type){
    	this.middleCenter.setTypeName(type);
    }

    public int getMiddleCenterID()	{
    	return this.middleCenter.getTypeID();
    }

    public String getMiddleCenterName(){
    	return this.middleCenter.getTypeName();
    }
    
    public void setRightCenter(String type){
    	this.rightCenter.setTypeName(type);
    }

    public int getRightCenterID()	{
    	return this.rightCenter.getTypeID();
    }

    public String getRightCenter(){
    	return this.rightCenter.getTypeName();
    }
    
    
    
    public void setLeftBelowTwo(String type){
    	this.leftBelowTwo.setTypeName(type);
    }

    public int getLeftBelowTwoID()	{
    	return this.leftBelowTwo.getTypeID();
    }

    public String getLeftBelowTwoName(){
    	return this.leftBelowTwo.getTypeName();
    }
    
    public void setRightBelowTwo(String type){
    	this.rightBelowTwo.setTypeName(type);
    }

    public int getRightBelowTwoID()	{
    	return this.rightBelowTwo.getTypeID();
    }

    public String getRightBelowTwoName(){
    	return this.rightBelowTwo.getTypeName();
    }
    
    
    
    public void setLeftBelowOne(String type){
    	this.leftBelowOne.setTypeName(type);
    }

    public int getLeftBelowOneID()	{
    	return this.leftBelowOne.getTypeID();
    }

    public String getLeftBelowOneName(){
    	return this.leftBelowOne.getTypeName();
    }

    public void setMiddleBelow(String type){
    	this.middleBelow.setTypeName(type);
    }

    public int getMiddleBelowID()	{
    	return this.middleBelow.getTypeID();
    }

    public String getMiddleBelowName(){
    	return this.middleBelow.getTypeName();
    }
    
    public void setRightBelowOne(String type){
    	this.rightBelowOne.setTypeName(type);
    }

    public int getRightBelowOneID()	{
    	return this.rightBelowOne.getTypeID();
    }

    public String getRightBelowOne(){
    	return this.rightBelowOne.getTypeName();
    }
     
}






