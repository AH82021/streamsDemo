import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class Solution {
    public static void main(String[] args) {
        System.out.println(malesOnly(Person.persons()));
        names(Person.persons()).forEach(System.out::println);
        sortedByIncomeDesc().forEach(System.out::println);

        System.out.println("Distinct genders "+distinctGenders());
        System.out.println("First three people on the list");
        firstThreePeople().forEach(System.out::println);
        System.out.println("List of people on the list skipped first two people");
        skippedPeople().forEach(System.out::println);
        System.out.println("person's income is greater than 8000.0 "+anyPersonWithHighIncome());

        System.out.println(personWithHighestIncome());
        if(personWithHighestIncome().isPresent()){
            Person p = personWithHighestIncome().get();
            System.out.println("Person with highest income is "+p);
        }
    }
   // Filter the list of persons to include only males.
    static List<String> malesOnly(List<Person> people){

        List<String> males = people.stream()
                .filter(Person::isMale)
                .map(Person::getName)
                .toList();
        return males;


    }
    //Map the list of persons to their names.

    static List<String> names(List<Person> people){
        List<String> names = people.stream()
                .map(Person::getName)
                .toList();
        return names;
    }

    // Sort the list of persons by their income in descending order.
   static List<Person> sortedByIncomeDesc(){
        List<Person> sortedList = Person.persons()
                .stream()
                .sorted(Comparator.comparing(Person::getIncome).reversed())
                .toList();
        return sortedList;
   }

   //Find the distinct genders in the list of persons.

    static List<Person.Gender> distinctGenders(){
        List<Person.Gender> genders = Person.persons()
                .stream()
                .map(Person::getGender)
                .distinct()
                .toList();
        return genders;
    }
    // To limit the list of persons to the first 3,
    static List<Person> firstThreePeople(){
        List<Person> top3 = Person.persons()
                .stream()
                .limit(3)
                .toList();
        return top3;
    }

    // To skip the first 2 persons in the list
   static List<Person> skippedPeople(){
        List<Person> skipped = Person.persons()
                .stream()
                .skip(2)
                .toList();
        return skipped;
    }

    // To use peek() to print the names of all persons in the list

    static void displayNames(){
        Person.persons()
                .stream()
                .peek(person -> System.out.println("Person name"+person.getName()))
                .forEach(System.out::println);
    }

    //To check if any person's income is greater than 8000.0,

    static boolean anyPersonWithHighIncome(){
     return    Person.persons()
                .stream()
                .anyMatch(p->p.getIncome()>8000);
    }
// check if all persons are male
    static boolean isAllPeopleAreMale(){
    return     Person.persons()
                .stream()
                .allMatch(Person::isMale);
    }

    static boolean noneHaveZeroIncome(){
    return     Person.persons()
                .stream()
                .noneMatch(p->p.getIncome()==0);
    }

    // To count the number of persons
    static long countFemale(){
     return    Person.persons()
                .stream()
                .filter(Person::isFemale)
                .count();
    }

    // To find the person with the highest income

    static Optional<Person> personWithHighestIncome(){
     return    Person.persons()
                .stream()
                .max(Comparator.comparingDouble(Person::getIncome));
    }











}
