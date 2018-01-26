package service;

import domain.Permission;
import domain.Person;
import domain.Role;
import domain.User;

import java.util.*;

public class UserService  {

    public static List<User> findUsersWhoHaveMoreThanOneAddress(List<User> users) {

        List<User> usersWhoHaveMoreThanOneAdress = new ArrayList<>();
        for (User user : users){
            if (user.getPersonDetails().getAddresses().size() > 1){
                usersWhoHaveMoreThanOneAdress.add(user);
            }
        }
        return usersWhoHaveMoreThanOneAdress;
    }

    public static Person findOldestPerson(List<User> users) {

        Person theOldestPerson = users.get(0).getPersonDetails();
        for (User user : users) {

            if (user.getPersonDetails().getAge() > theOldestPerson.getAge()) {
                theOldestPerson = user.getPersonDetails();
            }

        }

        return theOldestPerson;
    }

    public static User findUserWithLongestUsername(List<User> users) {

       User userWithLongestUsername = users.get(0);
        for (User user : users){
            if (user.getName().length() > userWithLongestUsername.getName().length()){
                userWithLongestUsername = user;

            }
        }

        return userWithLongestUsername;
    }

    // zamieniałem tutaj zmiena ze Stringa na Listę Stringów??? skoro moge posiadac więcej niż jednego dorosłego
    public static List<String> getNamesAndSurnamesCommaSeparatedOfAllUsersAbove18(List<User> users) {

        List<String> nameAndSurnameUsersAbove18 = new ArrayList<>();
        for (User user : users){
            if (user.getPersonDetails().getAge() > 18){
                nameAndSurnameUsersAbove18.add(user.getPersonDetails().getName() + ", " + user.getPersonDetails().getSurname());
            }
        }

        return nameAndSurnameUsersAbove18;
    }

    // Zmieniłem z Listy na TreeSet. Nie udało mi się tego jakoś posortować przez Colections.sort().
    public static TreeSet<Permission> getSortedPermissionsOfUsersWithNameStartingWithA(List<User> users) {

        List<Permission> permissinsOfUsersWhithNameStartingWithA = new ArrayList<>();
        for (User user : users) {
            if (user.getName().startsWith("A"));
           permissinsOfUsersWhithNameStartingWithA.add ((Permission) user.getPersonDetails().getRole().getPermissions());
        }
        TreeSet sortedPermissinsOfUsersWhithNameStartinsWithA = new TreeSet<>(permissinsOfUsersWhithNameStartingWithA);

        return sortedPermissinsOfUsersWhithNameStartinsWithA;
    }

    public static void printCapitalizedPermissionNamesOfUsersWithSurnameStartingWithS(List<User> users) {

        String capitalizedPermissionNamesOfUsersWithSurnameWithS;
        for (User user: users){
            if ( user.getPersonDetails().getSurname().startsWith("S"));
           capitalizedPermissionNamesOfUsersWithSurnameWithS =  user.getPersonDetails().getRole().getName().toUpperCase();
        }

    }

    public static Map<Role, List<User>> groupUsersByRole(List<User> users) {
        List<User> UserList = new ArrayList<>();
        Map<Role, List<User>> endingMaps = new HashMap<>();
        Role roles;
        for (User user : users) {
            roles = user.getPersonDetails().getRole();
            if (users.get(0) == user) {
                UserList.add(user);
                endingMaps.put(user.getPersonDetails().getRole(), UserList);
            } else {
                for (Role role:endingMaps.keySet()){
                    if (role.getName().equals(roles.getName())) {
                        endingMaps.get(role).add(user);
                        break;
                    }
                    else {
                        List<User> e = new ArrayList<>();
                        e.add(user);
                        endingMaps.put(user.getPersonDetails().getRole(), e);
                    }
                }
            }
        }
        return endingMaps;
    }
    public static Map<Boolean, List<User>> partitionUserByUnderAndOver18(List<User> users) {
        List<User> aa = new ArrayList<>();
        List<User> bb = new ArrayList<>();
        Map<Boolean,List<User>> aaa = new HashMap<>();
        for (User user:users){
            if(user.getPersonDetails().getAge() > 18){
                aa.add(user);
            }
            else {
                bb.add(user);
            }
        }
        aaa.put(true, aa);
        aaa.put(false, bb);
        return aaa;
    }}
