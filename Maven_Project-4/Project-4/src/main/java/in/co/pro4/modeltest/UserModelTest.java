package in.co.pro4.modeltest;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import in.co.pro4.bean.CollegeBean;
import in.co.pro4.bean.UserBean;
import in.co.pro4.exception.ApplicationException;
import in.co.pro4.exception.DuplicateRecordException;
import in.co.pro4.exception.RecordNotFoundException;
import in.co.pro4.model.UserModel;

public class UserModelTest {
	public static UserModel model = new UserModel();
	public static void main(String[] args) throws DuplicateRecordException, ParseException {
		//testadd();
		//testinsert();
		testDelete();
		//testUpdate();
		//testFindByPK();
		//testFindByLogin();
		//testSearch();
		//testGetRole();
		//testList();
		//testAuthenticate();
		//testRegisterUser();
		//testchangePassword();
		//testforgetPassword();
		//testresetPassword();
	}
		private static void testresetPassword() {
			
			  UserBean bean = new UserBean();
		        try {
		            bean = model.findByLogin("harish3@gmail.com");
		            if (bean != null) {
		                boolean pass = model.resetPassword(bean);
		                if (pass = false) {
		                    System.out.println("Test Update fail");
		                }
		            }

		        } catch (ApplicationException e) {
		            e.printStackTrace();
		        }

		    }
		private static void testforgetPassword() {
		
			  try {
		            boolean b = model.forgetPassword("verma33@gmail.com");

		            System.out.println("Suucess : Test Forget Password Success");

		        } catch (RecordNotFoundException e) {
		            e.printStackTrace();
		        } catch (ApplicationException e) {
		            e.printStackTrace();
		        }
		    }
		private static void testchangePassword() {
			
			   try {
		            UserBean bean = model.findByLogin("aniket33@gmail.com");
		            String oldPassword = bean.getPassword();
		           // bean.setId(1l);
		            bean.setPassword("1122");
		            bean.setConfirmPassword("1122");
		            String newPassword = bean.getPassword();
		            try {
		                model.changePassword(3L, oldPassword, newPassword);
		                System.out.println("password has been change successfully");
		            } catch (RecordNotFoundException e) {
		                e.printStackTrace();
		            }

		        } catch (ApplicationException e) {
		            e.printStackTrace();
		        }

		    }
		private static void testRegisterUser() throws ParseException {
		
			 try {
		            UserBean bean = new UserBean();
		            SimpleDateFormat sdf = new SimpleDateFormat("MM/dd/yyyy");

		            // bean.setId(8L);
		            bean.setFirstName("Roshni");
		            bean.setLastName("verma");
		            bean.setLogin("vermmma01@gmail.com");
		            bean.setPassword("ver@123");
		            bean.setConfirmPassword("4444");
		            bean.setDob(sdf.parse("07/06/1997"));
		            bean.setGender("Female");
		            bean.setRoleId(1);
		            long pk = model.registerUser(bean);
		            System.out.println("Successfully register");
		            System.out.println(bean.getFirstName());
		            System.out.println(bean.getLogin());
		            System.out.println(bean.getLastName());
		            System.out.println(bean.getDob());
		            UserBean registerbean = model.findByPK(pk);
		            if (registerbean != null) {
		                System.out.println("Test registation fail");
		            }
		        } catch (ApplicationException e) {
		            e.printStackTrace();
		        } catch (DuplicateRecordException e) {
		            e.printStackTrace();
		        }
		}
		private static void testAuthenticate() {
		try {
			UserBean bean = new UserBean();
			bean.setLogin("rajeshkumarhrm40@gmail.com");
			bean.setPassword("Rajesh@1995");
			bean = model.authenticate(bean.getLogin(),bean.getPassword());
			if(bean!=null) {
				 System.out.println("Successfully login");
			} else {
                System.out.println("Invalied login Id & password");
            }
		}catch (ApplicationException e) {
            e.printStackTrace();
        }
		
	}
		private static void testList() {
		try {
			UserBean bean = new UserBean();
			List list = new ArrayList();
			list = model.list(1,10);
			if(list.size()>0) {
				System.out.println("Test List is Fail");
			}
			Iterator it = list.iterator();
			while(it.hasNext()) {
				bean = (UserBean) it.next();
				System.out.println(bean.getId());
				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getGender());
				System.out.println(bean.getMobileNo());
				System.out.println(bean.getPassword());
				System.out.println(bean.getConfirmPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfulLogin());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
				System.out.println(bean.getCreatedBy());
				System.out.println(bean.getModifiedBy());
				System.out.println(bean.getCreatedDatetime());
				System.out.println(bean.getModifiedDatetime());
			}
		}catch (ApplicationException e) {
            e.printStackTrace();
        }
		
	}
		private static void testGetRole() {
	        try {
	            UserBean bean = new UserBean();
	            List list = new ArrayList();
	            bean.setRoleId(2L);
	            list = model.getRoles(bean);
	            if (list.size() < 0) {
	                System.out.println("Test Get Roles fail");
	            }
	            Iterator it = list.iterator();
	            while (it.hasNext()) {
	                bean = (UserBean) it.next();
	                System.out.println(bean.getId());
	                System.out.println(bean.getFirstName());
	                System.out.println(bean.getLastName());
	                System.out.println(bean.getLogin());
	                System.out.println(bean.getPassword());
	                System.out.println(bean.getDob());
	                System.out.println(bean.getRoleId());
	                System.out.println(bean.getUnSuccessfulLogin());
	                System.out.println(bean.getGender());
	                System.out.println(bean.getLastLogin());
	                System.out.println(bean.getLock());
	            }
	        } catch (ApplicationException e) {
	            e.printStackTrace();
	        }
	    }
		private static void testSearch() {
			try {
				UserBean bean = new UserBean();
				UserModel model = new UserModel();
				List list = new ArrayList();
				 bean.setId(1L);
				list = model.search(bean, 1, 10);
				if (list.size() < 0) {
					System.out.println("Test search fail");
				}
				Iterator it = list.iterator();
				while (it.hasNext()) {
					bean = (UserBean) it.next();
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getLogin());
					System.out.println(bean.getPassword());
					System.out.println(bean.getDob());
					System.out.println(bean.getRoleId());
					System.out.println(bean.getUnSuccessfulLogin());
					System.out.println(bean.getGender());
					System.out.println(bean.getLastLogin());
					System.out.println(bean.getLock());
				}
			} catch (ApplicationException e) {
				e.printStackTrace();
			}

		}
		private static void testFindByLogin() {
			try {
				UserBean bean = new UserBean();
				UserModel model = new UserModel();
				bean = model.findByLogin("verma33@gmail.com");
				if (bean == null) {
					System.out.println("Test findByLogin fail");
				}
				System.out.println(bean.getId());

				System.out.println(bean.getFirstName());
				System.out.println(bean.getLastName());
				System.out.println(bean.getLogin());
				System.out.println(bean.getPassword());
				System.out.println(bean.getDob());
				System.out.println(bean.getRoleId());
				System.out.println(bean.getUnSuccessfulLogin());
				System.out.println(bean.getGender());
				System.out.println(bean.getLastLogin());
				System.out.println(bean.getLock());
			} catch (ApplicationException e) {
				e.printStackTrace();
			}		
	}
		private static void testFindByPK() {
				try {
					UserBean bean = new UserBean();
					long pk = 5L;
					UserModel model = new UserModel();
					bean = model.findByPK(pk);
					if (bean == null) {
						System.out.println("Test find by pk fail");
					}
					System.out.println(bean.getId());
					System.out.println(bean.getFirstName());
					System.out.println(bean.getLastName());
					System.out.println(bean.getLogin());
					System.out.println(bean.getPassword());
					System.out.println(bean.getDob());
					System.out.println(bean.getRoleId());
					System.out.println(bean.getUnSuccessfulLogin());
					System.out.println(bean.getGender());
					System.out.println(bean.getLastLogin());
					System.out.println(bean.getLock());

				} catch (ApplicationException e) {
					e.printStackTrace();
			}		
	}
		private static void testUpdate() throws DuplicateRecordException {
			
			try {
				UserBean bean = new UserBean();
				UserModel model = new UserModel();
				bean = model.findByPK(1L);
				bean.setFirstName("Rajesh");
				bean.setLastName("Kumar");
				bean.setLogin("rajeshkumarhrm40@gmail.com");
				bean.setPassword("pass@121");
				bean.setUnSuccessfulLogin(1);
				model.update(bean);

				System.out.println("test update succ");

			} catch (ApplicationException e) {
				e.printStackTrace();
			}

		}

	private static void testDelete() {

		        try {
		            UserBean bean = new UserBean();
		            long pk = 3L;
		            bean.setId(pk);
		            model.delete(bean);
		            System.out.println("Test Delete succ" + bean.getId());
		            UserBean deletedbean = model.findByPK(pk);
		            
		        } catch (ApplicationException e) {
		            e.printStackTrace();
		        }
		    }

	private static void testinsert() throws DuplicateRecordException, ParseException {
		try {
            UserBean bean = new UserBean();
            SimpleDateFormat sdf = new SimpleDateFormat("MM-DD-yyy");

            // bean.setId(5234L);
            bean.setFirstName("cjhsghbdswv");
            bean.setLastName("kumevbebawat");
            bean.setLogin("abhi12@g.com");
            bean.setPassword("pass1234");
            bean.setDob(sdf.parse("31-12-1990"));
            bean.setRoleId(1L);
            bean.setUnSuccessfulLogin(2);
            bean.setGender("Male");
            bean.setLastLogin(new Timestamp(new Date().getTime()));
            bean.setLock("Yes");
            bean.setConfirmPassword("pass1234");
            long pk = model.add(bean);
            UserBean addedbean = model.findByPK(pk);
            System.out.println("Test add succ");
            if (addedbean == null) {
                System.out.println("Test add fail");
            }
        } catch (ApplicationException e) {
            e.printStackTrace();
        }

	}

	private static void testadd() throws ParseException, DuplicateRecordException {
		try {
			UserBean bean = new UserBean();
			SimpleDateFormat sdf = new SimpleDateFormat("MM-dd-yyyy");

			bean.setFirstName("Rajesh");
			bean.setLastName("Kumar");
			bean.setLogin("rajeshkumar@gmail.com");
			bean.setPassword("pass@121");
			bean.setMobileNo("8982213237");
			bean.setDob(sdf.parse("30-07-1995"));
			bean.setRoleId(1L);
			bean.setUnSuccessfulLogin(1);
			bean.setGender("Male");
			bean.setLastLogin(new Timestamp(new Date().getTime()));
			bean.setLock("Yes");
			bean.setConfirmPassword("pass@121");
			long pk = model.add(bean);
			UserBean addedbean = model.findByPK(pk);
			System.out.println("Test add succ");
			if (addedbean == null) {
				System.out.println("Test add fail");
			}
		} catch (ApplicationException e) {
			e.printStackTrace();
		}
	}
}
	

