/*die Klasse NoiseLevelhat nur ein Attribut, das den Lautstärkepegel angibt. Es wird dazu verwendet, den gesamten Lautstärkepegel zu messen. 
In Powerdrill erschaffen wir ein zweites NoiseLevel-Objekt aus dem Grund, dass die Methode add ein NoiseLevel-Argument braucht. 
Hätte man im aktuellen Zusammenhang mit int-argument machen können.
*/
public class NoiseLevel {
  private int pegel;
  //Der Konstruktor ist denkbar ainfach: eine neue Lautstärke 0.
public NoiseLevel(){
pegel=0;
};
//die get und set Methoden werden von anderen Klassen benötigt, um den privaten pegel verändern zu können. Z.B. in PowerDrill.makeNoise verwendet.
public void setPegel(int a){
this.pegel=a;
}
public int getPegel(){
    return this.pegel;
}
/*Das Herz der NoiseLevel-Klasse ist die add Methode. Sie bestimmt das Maximum aus zwei NoiseLevel-Objekten und setzt den akuellen Laustärkepegel auf dieses.
Wenn es über 10 ist, wird noch 1 addiert (warum eigentlich?)
*/
public void add(NoiseLevel uno){
if(uno.getPegel()>this.getPegel()){this.setPegel(uno.getPegel());}  //auf Maximum setzen
if(this.getPegel() >9&&uno.getPegel()>9){                           //wenn >= 10: pegel++
this.setPegel(this.getPegel()+1);
}
}
/*die Methode toString ist eigentlich schon belegt, deswegen müssen wir sie "Overriden". 
Sie liest den Pegel eines Noiselevel-Objekts und gibt je nach Größe einen String zurück.
Wird in ConstructionWork zur Ausgabe verwendet.
*/
  @Override
  public String toString(){
if(this.getPegel()>11){return "furchtbar laut";}
if(this.getPegel()>9){return "LAUT";}
if(this.getPegel()>4){return "laut";}
if(this.getPegel()>1){return "normal";}
return "leise";
}
}
