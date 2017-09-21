class PersonFinder {

  private LinearProbeHash finder = new LinearProbeHash(1000);

  ///////////////////////////////////////////////////////////

  private int calculateKey(String name){

    char[] charArr = name.toCharArray();
    int asciiKey = 0;

    for(int i=0; i<charArr.length; i++)
      asciiKey += (int) charArr[i];

    return asciiKey;
  }

  //////////////////////////////////////////////////////////

  public void addPerson(String name){
    Key newPerson = new Key(calculateKey(name),name);
    finder.insertElement(newPerson);
  }

  //////////////////////////////////////////////////////////

  public String searchPerson(String name){
    int j = finder.searchElement(new Key(calculateKey(name),name));
    if(j!=0)
      return "Registro #" + j + ": " + (finder.getIndex(j)).data.toString();
    else
      return "No existe registro de la persona que buscas.";
  }

  /////////////////////////////////////////////////////////

  public void deletePerson(String name){
    finder.deleteElement(new Key(calculateKey(name),name));
  }

  /////////////////////////////////////////////////////////

  public static void main(String[] args) {
    PersonFinder ps = new PersonFinder();
    ps.addPerson("Emanuel");
    System.out.println(ps.searchPerson("Emanuel"));
    ps.deletePerson("Emanuel");
    System.out.println(ps.searchPerson("Emanuel"));
  }


}
