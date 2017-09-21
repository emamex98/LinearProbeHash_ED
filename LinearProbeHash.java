class LinearProbeHash {

  private int m, i, numberOfKeys;
  private Key[] hashTable;
  private Key deleted;

  public LinearProbeHash(int tableSize){
    this.m = tableSize;
    this.hashTable = new Key[this.m];
    this.deleted = new Key(0,"");
    insertElement(deleted);
  }

  /////////////////////////////////////////////////////////

  private int hash(Key key){
    return (auxHash(key) + this.i) % this.m;
  }

  /////////////////////////////////////////////////////////

  private int auxHash(Key key){
    return key.k;
  }

  //////////////////////////////////////////////////////////

  public int insertElement(Key key){
    this.i = 0;
    int j = 0;

    while(this.i < this.m){
      j = hash(key);
      if(hashTable[j] == null || hashTable[j] == this.deleted){
        hashTable[j] = key;
        return j;
      }
      else{
        this.i++;
      }
    }

    return 0;
  }

  ////////////////////////////////////////////////////////////

  public int searchElement(Key key){
  // public int searchElement(int keyID){
    this.i = 0;
    int j = 0;

    while(this.i < this.m){
      j = hash(key);
      if(hashTable[j] != null){
        if (hashTable[j].k == key.k)
          return j;
        else
          this.i++;
        }
      else
        break;
    }
      return 0;
  }

  ////////////////////////////////////////////////////////////

  public void deleteElement(Key key){
    int j = searchElement(key);

    if(hashTable[j].data == key.data)
      hashTable[j] = this.deleted;

  }

  ///////////////////////////////////////////////////////////

  public Key getIndex(int j){
    return hashTable[j];
  }

  ////////////////////////////////////////////////////////////

  public void printTable(){
    for(int i=0; i<this.m; i++){
      if(this.hashTable[i] != null)
        System.out.println(i + ": " + this.hashTable[i].data);
    }
  }

  ////////////////////////////////////////////////////////////

  // public static void main(String[] args) {
  //   LinearProbeHash lph = new LinearProbeHash(5);
  //   Key k22 = new Key(22,"Emanuel");
  //   lph.insertElement(k22);
  //   lph.insertElement(new Key(57,"Marisol"));
  //   lph.insertElement(new Key(3,"Sara"));
  //   lph.insertElement(new Key(16,"Joaquin"));
  //   lph.insertElement(new Key(1,"Marisa"));
  //   lph.printTable();
  //   System.out.println("Llave 7 esta en index "+lph.searchElement(7));
  //   lph.deleteElement(k22);
  //   //lph.insertElement(k22);
  //   lph.printTable();
  // }

}
