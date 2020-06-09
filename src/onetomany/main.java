package onetomany;

import java.util.List;

import java.util.HashSet;
import java.util.Set;

import java.util.Scanner;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.transform.Transformers;

import Entity_hibernate.PersonDetail_onetomany;
import Entity_hibernate.barangay_onetomany;
import databaseutil.dbutil;

public class main {

	static Scanner input = new Scanner(System.in);
	static barangay_onetomany bname = new barangay_onetomany();
	static PersonDetail_onetomany pd =new  PersonDetail_onetomany();

	public static void main(String[] args) {

		System.out.println("Choose any of the following below: ");
		System.out.println("[1]-INSERT\n[2]-SELECT\n[3]-MODIFY");
		System.out.print("Enter number: ");
		int ch = input.nextInt();

		switch(ch) {

		case 1: 

			Session session = dbutil.getSession();
			Transaction tx = null;

			System.out.println("Please enter the following details: ");
			System.out.print("Lastname: ");
			String lname = input.next();
			System.out.print("Firstname: ");
			String fname = input.next();
			System.out.print("Middlename: ");
			String mname = input.next();
			System.out.print("Barangay: ");
			String b = input.next();
			System.out.print("Age: ");
			int age = input.nextInt();

			int addnames = lname.length() + mname.length();
			int addnames1 = fname.length()+lname.length() + mname.length();
			System.out.println("lastname and middlename length: " + addnames);
			System.out.println("LMF length: " + addnames1);

			if(pd.fibs(age)%2 == 0) {
				try {

					tx = session.beginTransaction();

					pd.setLastname(lname);
					pd.setFirstname(fname);
					pd.setMiddlename(mname);
					pd.AgeCheck(age);
					pd.setAge(age);

					Set<barangay_onetomany> barangays = new HashSet<>();
					bname.setBname(b);
					barangays.add(bname);

					pd.setBarangays(barangays);

					Integer id = (Integer) session.save(pd);
					System.out.println("your id: " + id);

					int fib[] = new int[age];
					fib[0] = 0;
					fib[1] = 1;

					for (int i = 2; i < age; i++) {
						fib[i] = fib[i - 1] + fib[i - 2];
					}

					pd.check(fib, addnames, addnames1);
					tx.commit();
					System.out.println("---------------Details added-------------------");

				} catch (Exception ex) {

					if (tx != null) {
						tx.rollback();
					}

					ex.printStackTrace();
				} finally {
					session.close();
				}
				System.out.println("---System closed---");
				System.exit(0);
			}
			else {

				try {

					tx = session.beginTransaction();

					pd.setLastname(lname);
					pd.setFirstname(fname);
					pd.setMiddlename(mname);
					pd.AgeCheck(age);
					pd.setAge(age);

					Set<barangay_onetomany> barangays = new HashSet<>();
					bname.setBname(b);
					barangays.add(bname);

					pd.setBarangays(barangays);


					int fib[] = new int[age];
					fib[0] = 0;
					fib[1] = 1;

					for (int i = 2; i < age; i++) {
						fib[i] = fib[i - 1] + fib[i - 2];
					}

					Integer id = (Integer) session.save(pd);
					System.out.println("your id: " + id);
					pd.check(fib, addnames, addnames1);
					tx.commit();
					System.out.println("---------------Details added-------------------");
				} catch (Exception ex) {

					if (tx != null) {
						tx.rollback();
					}
					ex.printStackTrace();

				} finally {
					session.close();
				}

				System.out.println("---System closed---");
				System.exit(0);
			}
			break;

		case 2: 	

			Session session1 = dbutil.getSession();

			System.out.println("Please enter the following details: ");
			System.out.print("ID: ");
			int id = input.nextInt();
			System.out.print("Lastname: ");
			String last = input.next();

			try {

				Query query = session1.createSQLQuery("select id AS id,"
						+ "lastname AS lastname, firstname AS firstname, "
						+ "middlename AS middlename, age as age from persondetail where Id = :Id and lastname = :lastname");
				query.setParameter("Id", id);
				query.setParameter("lastname", last);


				query.setResultTransformer(Transformers.aliasToBean(PersonDetail_onetomany.class));

				pd = (PersonDetail_onetomany) query.uniqueResult();

				StringBuilder sb = new StringBuilder();

				if(pd.getMiddlename()==null) {

					sb =new StringBuilder (pd.getLastname());
					String lastname_1 = "" + sb.reverse();
					sb =new StringBuilder (pd.getFirstname());
					String fname_1 = "" + sb.reverse();
					String number_1 = String.valueOf(pd.getAge() );

					String xx1 = "";
					for(int i = number_1.length() - 1; i >= 0; i--) {
						xx1 = xx1 + number_1.charAt(i);
					}
					System.out.println("Reversing details....");
					Thread.sleep(2000);
					System.out.println();

					List <PersonDetail_onetomany> personList = query.list();

					for(PersonDetail_onetomany person: personList) {
						System.out.println("Persons id: " + person.getId());
						System.out.println("Last Name: " + lastname_1);
						System.out.println("First Name: " + fname_1);
						System.out.println("Age: " + xx1);
					}
					System.out.println();
					System.out.println("---System closed---");
					System.exit(0);

				}else {

					sb =new StringBuilder (pd.getLastname());
					String lastname_ = "" + sb.reverse();
					sb =new StringBuilder (pd.getFirstname());
					String fname_ = "" + sb.reverse();
					sb =new StringBuilder (pd.getMiddlename());
					String mname_ = "" + sb.reverse();
					String number_ = String.valueOf(pd.getAge() );

					String xx = "";
					for(int i = number_.length() - 1; i >= 0; i--) {
						xx = xx + number_.charAt(i);
					}
					System.out.println("Reversing details....");
					Thread.sleep(2000);
					System.out.println();

					List <PersonDetail_onetomany> personList = query.list();
					for(PersonDetail_onetomany person: personList) {
						System.out.println("Persons id: " + person.getId());
						System.out.println("Last Name: " + lastname_);
						System.out.println("First Name: " + fname_);
						System.out.println("Middle Name: " + mname_);
						System.out.println("Age: " + xx);
					}
					System.out.println("---System closed---");
					System.exit(0);
				}
			} catch (Exception ex) {
				System.out.println("---NO DATA FOUND---");
				System.exit(0);
				ex.printStackTrace();
			} finally {
				session1.close();
			}

			break;

		case 3: 	

			System.out.println("Please enter the following details: ");
			System.out.print("Id: ");
			int id_ = input.nextInt();
			System.out.print("Lastname: ");
			String ln = input.next();
			System.out.print("Firstname: ");
			String ff = input.next();
			System.out.print("Middlename: ");
			String mm = input.next();
			System.out.print("Age: ");
			int aa = input.nextInt();
			System.out.print("barangay: ");
			String bb = input.next();

			int fib[] = new int[aa]; 
			fib[0] = 0;
			fib[1] = 1;

			for (int i = 2; i < aa; i++) {
				fib[i] = fib[i - 1] + fib[i - 2];
			}

			System.out.println("fibonacci sequence: ");
			for (int i = 0; i < aa; i++) { //display user's age
				System.out.println(fib[i]);
			}

			int results[] = new int[2];
			int even = 0;
			int odd = 0;

			for(int h = 0; h < fib.length;h ++) {

				if(fib[h] % 2 == 0) {
					even +=1;

				}else {
					odd += 1;
				}
			}

			results[0] = even;
			results[1] = odd;
			System.out.println("-------------------------");
			System.out.println("# of even nos.: "+even);
			System.out.println("# of odd nos.: "+odd );

			if(even >10) {
				Session session2 = dbutil.getSession();
				Transaction tx2 = null;

				try {
	
					tx2 = session2.beginTransaction();

					pd  = (PersonDetail_onetomany) session2.get(PersonDetail_onetomany.class, id_);
					pd.setLastname(ln);
					pd.setFirstname(ff);
					pd.setMiddlename(mm);
					pd.setAge(aa);

					bname.setBname(bb);
					pd.getBarangays().add(bname);

					session2.update(pd);
					tx2.commit();

				} catch (Exception ex) {
					if (tx2 != null) {
						tx2.rollback();
					}
					System.out.println("NO EXISTING DATA FOUND");
					System.exit(0);
					ex.printStackTrace();
				} finally {
					session2.close();
				}		
				System.out.println("---Details updated, system closed---");
				System.exit(0);
			}
			else if(odd < 10) {
				Session session4 = dbutil.getSession();
				Transaction tx4 = null;
				try {

					tx4 = session4.beginTransaction();
					pd = (PersonDetail_onetomany) session4.get(PersonDetail_onetomany.class, id_);
					session4.delete(pd);
					tx4.commit();

				} catch (Exception ex) {
					if (tx4!= null) {
						tx4.rollback();
					}
					System.out.println("NO Data FOUND TO BE DELETED");
					System.exit(0);
					ex.printStackTrace();
				} finally {
					session4.close();
				}		
				System.out.println("---Detail/s deleted, system closed---");
				System.exit(0);
			}else if(!(even >= 10)) {
				Session session11 = dbutil.getSession();
				Transaction tx11 = null;
				try {

					tx11 = session11.beginTransaction();
					pd = (PersonDetail_onetomany) session11.get(PersonDetail_onetomany.class, id_);
					session11.delete(pd);
					tx11.commit();

				} catch (Exception ex) {
					if (tx11!= null) {
						tx11.rollback();
					}
					System.out.println("NO Data FOUND TO BE DELETED");
					System.exit(0);
					ex.printStackTrace();
				} finally {
					session11.close();
				}		
				System.out.println("---Details deleted, system closed---");
				System.exit(0);
			}
			else if(odd >= 10) {

				Session session00 = dbutil.getSession();
				Transaction tx00 = null;

				try {

					tx00 = session00.beginTransaction();

					pd  = (PersonDetail_onetomany) session00.get(PersonDetail_onetomany.class, id_);
					pd.setLastname(ln);
					pd.setFirstname(ff);
					pd.setMiddlename(mm);
					pd.setAge(aa);

					bname.setBname(bb);
					pd.getBarangays().add(bname);

					session00.update(pd);
					tx00.commit();

				} catch (Exception ex) {
					if (tx00 != null) {
						tx00.rollback();
					}
					System.out.println("NO DATA FOUND");
					System.exit(0);
					ex.printStackTrace();
				} finally {
					session00.close();
				}		
				System.out.println("---Details updated, system closed---");
				System.exit(0);
			}
			break;

		default: 
			System.out.println("Input invalid please try again....");
			main(args);
		}
	}
}
