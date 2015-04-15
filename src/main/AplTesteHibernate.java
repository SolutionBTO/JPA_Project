package main;

import java.sql.Date;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.swing.JOptionPane;

import entities.Produtos;



/**
 * class main
 * @author Solutionbto
 *
 */
public class AplTesteHibernate {
	
	static final int INSERT=1;
	static final int UPDATE=2;
	static final int DELETE=3;
	static final int SAIR=4;
	
	public static void main(String[] args) {

		EntityManagerFactory factory =
				Persistence.createEntityManagerFactory("JPA_TESTE");
		EntityManager em = factory.createEntityManager();
		int opt=0;
		Produtos p=null;
		
		try{	
			
			while(opt != SAIR){
				p=null;
				String resp=JOptionPane.showInputDialog(
						null,
						"Escolha as seguintes operações:\n"
								+ "1-Inserir,2-Alterar,3-Excluir,4-Sair",
								SAIR);
				try{
					
					try{
						opt=Integer.parseInt(resp);
					}catch(Exception e){
						throw new Exception("Digite um valor numérico!!!");
					}
					
				    if(opt < INSERT || opt > SAIR)
				    	throw new Exception("Valor incorreto, fora das opções!!!");
					
					switch (opt) {
						case INSERT:
							p = new Produtos();
							p.setNome(JOptionPane.showInputDialog("Digite nova descrição:"));
							p.setPreco(Math.random()*99);
							p.setData_cad(new Date(new java.util.Date().getTime()));
							break;
						case UPDATE:
							p=em.find(Produtos.class, Integer.parseInt(JOptionPane.showInputDialog("Digite o indice:")));
							p.setNome(JOptionPane.showInputDialog("Digite nova descrição:"));
							p.setPreco(Math.random()*99);
							break;
						case DELETE:
							p=em.find(Produtos.class, Integer.parseInt(JOptionPane.showInputDialog("Digite o indice:")));
							em.remove(p);
							break;
					}

					if(p != null){
						em.getTransaction().begin();
						
						if(opt != 3)
							em.persist(p);
						
						em.getTransaction().commit();
					}
					
				}catch(Exception e){
					JOptionPane.showMessageDialog(null, "Ocorreu um erro, causa: "+e.getMessage());
					e.printStackTrace();
				}
			}

		}finally{
			if(em.isOpen())
				em.close();
		}

	}
}
