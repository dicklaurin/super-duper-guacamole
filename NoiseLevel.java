
public class NoiseLevel {
  private int pegel;
public NoiseLevel(){
pegel=0;
};
public void setPegel(int a){
this.pegel=a;
}
public int getPegel(){
    return this.pegel;
}
public void add(NoiseLevel uno){
if(uno.getPegel()>this.getPegel()){this.setPegel(uno.getPegel());}  //auf Maximum setzen
if(this.getPegel() >9&&uno.getPegel()>9){                           //wenn >= 10: pegel++
this.setPegel(this.getPegel()+1);
}
}
  @Override
  public String toString(){
if(this.getPegel()>11){return "furchtbar laut";}
if(this.getPegel()>9){return "LAUT";}
if(this.getPegel()>4){return "laut";}
if(this.getPegel()>1){return "normal";}
return "leise";
}
}
