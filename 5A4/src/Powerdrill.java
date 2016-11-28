/**
 * Klasse zur Repraesentation einer Bohrmaschine.
 *
 * Bohrmaschinen werden durch ihre Akku-Ladung und ihren Bohrer-Durchmesser und -Typ
 * charakterisiert. Die Klasse stellt Methoden zum Aufladen des Akkus und zum Bohren
 * in verschiedene Materialien zur Verfuegung. Beim Bohren wird auch die Geraeuschentwicklung
 * berechnet.
 */

/*TODO g)*/ class Powerdrill {

  /**
   * Maximale Ladung der Akkus aller Bohrer.
   */
  /*TODO g)*/ static final double max_power = 5.0;              //muss static gesetzt werden, da auf die Klasse PowerDrill zugegriffen wird und nicht einzelne Objekte

  /**
   * Ladung des Akkus
   */
  /*TODO g)*/ private double power;                             // datenkapselung. man darf mögllichst wenig von PowerDrill-Objekten sehen.  für alle private gesetzen Methoden und Variablen gilt, dass sie nur in dieser Klasse benutzt werden.           
  /**
   * Durchmesser des Bohrers
   */
  /*TODO g)*/ private int bitSize;                                      
  /**
   * Typ des Bohrers
   */
  /*TODO g)*/ private BitType bit;

  /**
   * Lese fuer den Bohrer-Typ.
   * @return der eingesetzte Bohrer-Typ
   */
  /*TODO g)*/private BitType getBitType() {
    return this.bit;
  }
  /** 
   * Schreibe den Bohrer-Typ.
   * @param bit zu setzender Typ
   */
  /*TODO g)*/ private void setBitType(BitType bit) {
    this.bit = bit;
  }
  /**
   * Lese Bohrer-Durchmesser
   * @return der eingesetzte Bohrer-Durchmesser
   */
  /*TODO g)*/private int getBitSize() {
    return this.bitSize;
  }
  /**
   * Schreibe den Bohrer-Durchmesser
   * @param size neuer Bohrer-Durchmesser
   */
  /*TODO g)*/private void setBitSize(int size) {
    this.bitSize = size;
  }

  /**
   * Erzeugt einen neuen Bohrer mit vollem Akku
   * @param bit eingesetzter Bohrer-Typ
   * @param bitSize eingesetzter Bohrer-Durchmesser
   */
  /*TODO g)*/protected Powerdrill(BitType bit, int bitSize) {
    this.bit = bit;
    this.bitSize=bitSize;
    this.power = Powerdrill.max_power;
  }
  /**
   * Erzeugt einen neuen Bohrer mit angegebener Ladung.
   *
   * Uebersteigt die angegebene Ladung die maximale Ladung,
   * wird ein Bohrer mit vollem Akku erzeugt.
   *
   * @param power Ladung
   * @see Powerdrill(BitType, int)
   */
  /*TODO g)*/protected Powerdrill(BitType bit, int bitSize, double power) {     //ein Konstruktor ist protected, da ConstructionWork auf ihn zugreift. public ist natürlich überall möglich, aber das wollen wir anscheinend nicht
    this.bit = bit;
    this.bitSize = bitSize;
    if(power < Powerdrill.max_power) {
      this.power = power;
    } else {
      this.power = Powerdrill.max_power;
    }
  }
  /**
   * Laedt den Akku um den angegebenen Anteil auf, maximal jedoch voll.
   * @param ammount Anteil einer vollen Ladung, der aufgeladen werden soll.
   */
  /*TODO g)*/protected void charge(double amount) {                                 //wird in ConstructionWork aufgerufen.
    this.power += Powerdrill.max_power * amount;
    if (this.power > Powerdrill.max_power) {
      this.power = Powerdrill.max_power;
    }
  }

  /**
   * Fuehrt eine Bohrung durch.
   *
   * Eine Bohrung ist erfolgreich, wenn der eingesetzte Bohrer mit
   * material kompatibel ist und vor dem Aufruf der Methode
   * noch genug Akku-Ladung vorhanden war.
   *
   * @param material Das gebohrte Material
   * @param noise Das Geraeuschniveau in der Umgebung (wird aktualisiert)
   *
   * @return Ob erfolgreich gebohrt wurde
   */
  /*TODO g)*/protected boolean drill(Material material, NoiseLevel noise) {         //die Klasse ConstructionWork ruft diese Methode auf. Deswegen ist protected die kleinstmögliche Kapselung
    boolean correctBit = false;
    for(Material mat : BitType.canHandle(this.bit)) {                       //wofür haben wir die BitType getter und setter?
      if(mat == material) {
        correctBit = true;
      }
    }
    
    boolean hasPower = this.usePower(material, correctBit);
    if(hasPower) {
      this.makeNoise(material, noise, correctBit);
    }

    return correctBit && hasPower;
  }
  
  /**
   * Reduziert die Akku-Ladung entsprechend der beim Bohren verbrauchten Energie.
   * @param material Material, in das gebohrt wird.
   * @param correctBit gibt an, ob der aktuelle Bohrer mit material kompatibel ist
   * @return ob noch genug Energie im Akku war.
   */
  /*TODO g)*/ private boolean usePower(Material material, boolean correctBit) {         //die Methode wird nur in PowerDrill aufgerufen, deswegen ist private erlaubt
    if(correctBit && this.power > 0.5) {
      switch(material) {
        case Wood:
        case Plastic:
          this.power *= 0.75;
          break;
        case Metal:
          this.power *= 0.6;
          break;
        case ReinforcedConcrete:
          this.power *= 0.4;
        default:
          this.power *= 0.5;
      }
      return true;
    } else if( this.power > 0.5) {
      this.power -= 0.5;
      return true;
    } else {
      return false;
    }
  }
private void makeNoise(Material material, NoiseLevel noise, boolean correctBit){        //ich habe die Aufgabe so verstanden, dass die Methode add benutzt werden soll und nicht der Pegel erhöht.
    NoiseLevel additional = new NoiseLevel();
   
        switch(material){
            case Wood: if(correctBit){ additional.setPegel(5); }else{additional.setPegel(10);} noise.add(additional);break;
            case Plastic: if(correctBit){additional.setPegel(5);}else{additional.setPegel(10);} noise.add(additional);break;
            case Metal: if(correctBit&&(bitSize+3<=10)){additional.setPegel(bitSize+3);}else{additional.setPegel(10);}noise.add(additional);break;
            case Concrete:case Stone: case ReinforcedConcrete: if(correctBit){additional.setPegel(11);}else{additional.setPegel(8);}noise.add(additional);break;
        }
    
};
  /**
   * Aktualisiert das Geraeuschniveau in der Umgebung beim Bohren.
   *
   * Holz- und Kunststoff-Bohren erhoeht das aktuelle Geraeuschniveau um 5
   * Metall-Bohren mit einem kompatiblen Bohrer erhoeht das Geraeuschniveau um
   * 3 + Bohrer-Durchmesser, aber hoechstens um 10,
   * bei falschem Bohrer immer um 10.
   * Alles andere Bohren erhoeht bei kompatiblem Bohrer das aktuelle Geraeuschniveau um
   * 11, sonst um 8.
   *
   * @param material Das zu bohrende Material
   * @param noise Das aktuelle Geraeuschniveau der Umgebung (wird aktualisiert)
   * @param correctBit gibt an ob, der aktuelle Bohrer mit material kompatibel ist
   * 
   */
  /*TODO h)*/ 
}
