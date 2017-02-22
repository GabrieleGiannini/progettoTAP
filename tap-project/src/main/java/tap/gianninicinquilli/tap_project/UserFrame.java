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
		setSize(400,200);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		JButton btnGetRestaurantList = new JButton("get Restaurant list");
		list.setVisible(true);
		list.setName("resultList");
		btnGetRestaurantList.setName("restButton");
		
		btnGetRestaurantList.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				list.setListData(userC.getRestaurantsList().toArray());
				list.setVisible(true);
			}
		});
		
		JButton btnGetMenuOf = new JButton("get Menu' of:");
		btnGetMenuOf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] menu = new String[1];
				menu[0]="Menu";
				list.setListData(menu);
				list.setVisible(true);
			}
		});
		
		textField = new JTextField();
		textField.setColumns(10);
		
		JButton btnGetInformations = new JButton("get Informations");
		btnGetInformations.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] informations = new String[1];
				informations[0]="Informations";
				list.setListData(informations);
				list.setVisible(true);
			}
		});
		
		JButton btnGetReviews = new JButton("get Reviews");
		btnGetReviews.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] reviews = new String[1];
				reviews[0]="Reviews";
				list.setListData(reviews);
				list.setVisible(true);
			}
		});
		
		JButton btnGetCart = new JButton("get Cart");
		btnGetCart.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String[] Cart = new String[1];
				Cart[0]="Cart";
				list.setListData(Cart);
				list.setVisible(true);
			}
		});
		GroupLayout groupLayout = new GroupLayout(getContentPane());
		groupLayout.setHorizontalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
						.addGroup(groupLayout.createParallelGroup(Alignment.LEADING)
							.addComponent(btnGetRestaurantList)
							.addGroup(groupLayout.createSequentialGroup()
								.addComponent(btnGetMenuOf)
								.addPreferredGap(ComponentPlacement.RELATED)
								.addComponent(textField, GroupLayout.PREFERRED_SIZE, 111, GroupLayout.PREFERRED_SIZE))
							.addComponent(btnGetInformations)
							.addComponent(btnGetReviews))
						.addComponent(btnGetCart))
					.addPreferredGap(ComponentPlacement.RELATED, 10, Short.MAX_VALUE)
					.addComponent(list, GroupLayout.PREFERRED_SIZE, 135, GroupLayout.PREFERRED_SIZE)
					.addContainerGap())
		);
		groupLayout.setVerticalGroup(
			groupLayout.createParallelGroup(Alignment.LEADING)
				.addGroup(groupLayout.createSequentialGroup()
					.addContainerGap()
					.addComponent(btnGetRestaurantList)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addGroup(groupLayout.createParallelGroup(Alignment.BASELINE)
						.addComponent(btnGetMenuOf)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGetInformations)
					.addPreferredGap(ComponentPlacement.RELATED)
					.addComponent(btnGetReviews)
					.addPreferredGap(ComponentPlacement.RELATED, 8, Short.MAX_VALUE)
					.addComponent(btnGetCart))
				.addGroup(groupLayout.createSequentialGroup()
					.addComponent(list, GroupLayout.DEFAULT_SIZE, 172, Short.MAX_VALUE)
					.addContainerGap())
		);
		getContentPane().setLayout(groupLayout);
		
	}
}
