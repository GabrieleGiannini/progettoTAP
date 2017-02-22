package tap.gianninicinquilli.tap_project;

import javax.swing.JFrame;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JList;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;

public class UserFrame extends JFrame{
	
	JList list;
	private String[] restArr;
	private JTextField textField;
	public UserFrame(UserController userC) {	
		super();
		setVisible(true);
		list = new JList();
		setSize(400,250);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JButton btnGetRestaurantList = new JButton("get Restaurant list");
		list.setVisible(true);
		list.setName("resultList");
		btnGetRestaurantList.setName("restButton");
		String[] restList = new String[10];
		
		for(int i=0;i<userC.getRestaurantsList().size();i++){
			restList[i]=userC.getRestaurantsList().get(i).getName();
		}
		btnGetRestaurantList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.setListData(restList);
				list.setVisible(true);
			}
		});
		
		JButton btnGetMenuOf = new JButton("get Menu' of:");
		btnGetMenuOf.setName("getMenu");
		btnGetMenuOf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				List<Dish> menuList;
				String[] menu = new String[10];
				for(int i=0;i<userC.getRestaurantsList().size();i++){
					if(userC.getRestaurantsList().get(i).getName().equals(textField.getText())){
							menuList = userC.getRestaurantsList().get(i).getMenu();
							for(int j=0;j<menuList.size();j++){
								menu[j]=menuList.get(j).getID();
							}
					}
				}
				list.setListData(menu);
				list.setVisible(true);
			}
		});
		
		textField = new JTextField();
		textField.setName("nameRes");
		textField.setColumns(10);
		
		JButton btnGetInformations = new JButton("get Informations");
		btnGetInformations.setName("getInfo");
		btnGetInformations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.setListData(userC.getInformations().toArray());
				list.setVisible(true);
			}
		});
		
		JButton btnGetReviews = new JButton("get Reviews");
		btnGetReviews.setName("getRev");
		btnGetReviews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.setListData(userC.getReviews().toArray());
				list.setVisible(true);
			}
		});
		
		JButton btnGetCart = new JButton("get Cart");
		btnGetCart.setName("getCart");
		btnGetCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Cart cart = userC.getCart();
				String[] carrello = new String[cart.size()];
				for(int i=0;i<cart.size();i++){
					carrello[i]=cart.get(i).getID();
				}
				list.setListData(carrello);
				list.setVisible(true);
			}
		});
		
		JList list_1 = new JList();
		list_1.setName("dragDrop");
		list_1.setListData(new String[1]);
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.TRAILING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createSequentialGroup()
							.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
								.addComponent(btnGetRestaurantList)
								.addGroup(groupLayout.createSequentialGroup()
									.addComponent(btnGetMenuOf)
									.addPreferredGap(ComponentPlacement.RELATED)
									.addComponent(textField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
								.addComponent(btnGetInformations)
								.addComponent(btnGetReviews))
							.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
							.addGroup(groupLayout.createParallelGroup(Alignment.TRAILING)
								.addComponent(list_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(list, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)))
						.addComponent(btnGetCart))
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(list, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(groupLayout.createSequentialGroup()
							.addContainerGap()
							.addComponent(btnGetRestaurantList)
							.addPreferredGap(ComponentPlacement.RELATED)
							.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
								.addComponent(btnGetMenuOf)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
							.addPreferredGap(ComponentPlacement.RELATED)
							.addComponent(btnGetInformations)))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING, false)
						.addComponent(list_1, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addComponent(btnGetReviews, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGetCart)
					.addContainerGap(52, Short.MAX_VALUE))
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
