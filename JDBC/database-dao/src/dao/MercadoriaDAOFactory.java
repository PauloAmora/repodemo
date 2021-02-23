package dao;

public class MercadoriaDAOFactory {
	public static MercadoriaDAO createDAO() {
		return new MercadoriaDAOImpl();
	}

}
