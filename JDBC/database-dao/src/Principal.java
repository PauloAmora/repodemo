import java.util.List;
import java.util.Scanner;

import dao.MercadoriaDAO;
import dao.MercadoriaDAOFactory;
import model.Mercadoria;

public class Principal {

	public static void main(String[] args) {
		Scanner s = new Scanner(System.in);
		System.out.println("Escolha a opcao");
		System.out.println("1 - Criar mercadoria");
		System.out.println("2 - Atualizar mercadoria");
		System.out.println("3 - Procurar por nome");
		System.out.println("4 - Listar todos");
		System.out.println("5 - Vender");

		int o = s.nextInt();
		Mercadoria m = new Mercadoria();
		MercadoriaDAO mDao = MercadoriaDAOFactory.createDAO();
		List<Mercadoria> l = null;
		switch (o) {
		case 1:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome da mercadoria");
			m.setNome(s.next());
			System.out.println("Insira a quantidade da mercadoria");
			m.setQuantidade(s.nextInt());
			System.out.println("Insira o preco da mercadoria");
			m.setPreco(s.nextFloat());
			mDao.create(m);
			break;
		case 2:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome a ser atualizado");
			m = mDao.findByName(s.next());
			System.out.println("Insira a quantidade");
			m.setQuantidade(s.nextInt());
			System.out.println("Insira o preco");
			m.setPreco(s.nextFloat());
			mDao.update(m);
			break;
		case 3:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome a ser pesquisado:");
			String nome = s.next();
			m = mDao.findByName(nome);
			if (m != null) {
				System.out.println("Objeto recuperado:");
				System.out.println(
						"Nome: " + m.getNome() + " Quantidade: " + m.getQuantidade() + " Preco: " + m.getPreco());
			} else {
				System.out.println("Objeto de nome " + nome + " nao encontrado");
			}
			break;
		case 4:
			System.out.println();
			System.out.println();
			System.out.println("Lista de objetos");
			l = mDao.findAll();
			for (Mercadoria m1 : l) {
				System.out.println("Objeto recuperado:");
				System.out.println(
						"Nome: " + m1.getNome() + " Quantidade: " + m1.getQuantidade() + " Preco: " + m1.getPreco());
			}
			break;
		case 5:
			System.out.println();
			System.out.println();
			System.out.println("Insira o nome da mercadoria para venda");
			m = mDao.findByName(s.next());
			System.out.println("Quantidade da venda?");
			int i = s.nextInt();
			if (m.getQuantidade() < i) {
				System.out.println("Venda cancelada, quantidade maior que a disponivel");
			} else {
				m.setQuantidade(m.getQuantidade() - i);
				mDao.update(m);
				System.out.println("Venda efetuada, nova quantidade: " + m.getQuantidade());
			}
			break;
		default:
			System.out.println();
			System.out.println();
			System.out.println("Saindo do programa");
			break;
		}

	}

}
