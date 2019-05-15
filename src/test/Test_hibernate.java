package test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.junit.Test;

import model.Student;
import utils.HbnUtils;

public class Test_hibernate {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Student s1 = new Student();
		s1.setSname("张三");
		Configuration config = new Configuration().configure();

		SessionFactory sf = config.buildSessionFactory();

		Session session = sf.getCurrentSession();

		Transaction tx = null;
		try {
			tx = session.beginTransaction();
			session.save(s1);
			tx.commit();

		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {

			sf.close();
		}

	}

	// save
	@Test
	public void saveStudent() {
		Student s1 = new Student();
		s1.setSname("进行插入操作");
		Session session = HbnUtils.getSession();
		try {
			session.beginTransaction();
			session.save(s1);
			System.out.println(s1.getSname());
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		System.out.println(s1.getSname());

	}

	// delete
	@Test
	public void deleteStudent() {
		Student s1 = new Student();
		s1.setSid(1);
		Session session = HbnUtils.getSession();
		try {
			session.beginTransaction();
			session.delete(s1);
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}
		System.out.println(s1.getSname());

	}

	// update
	@Test
	public void updateStudent() {
		Student s1 = new Student();
		s1.setSname("update");
		s1.setSid(2);
		Session session = HbnUtils.getSession();
		try {
			session.beginTransaction();
			session.update(s1);
			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}

	}

	// load
	@Test
	public void loadStudent() {

		Session session = HbnUtils.getSession();
		try {

			session.beginTransaction();
			Student s1 = session.load(Student.class, 1);
			System.out.println(s1.getSname() + s1.getSid());

			session.getTransaction().commit();

		} catch (Exception ex) {
			ex.printStackTrace();
			session.getTransaction().rollback();
		}

	}
}
