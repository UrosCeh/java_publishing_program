/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view.controller;

import domainClient.Article;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import view.coordinator.ViewCoordinator;
import view.form.FrmMain;

/**
 *
 * @author hatch
 */
public class MainController {
    private final FrmMain frmMain;
    
    public MainController(FrmMain frmMain) {
        this.frmMain = frmMain;
    }

    public void openForm() {
        addHeaderBtns();
        addHeaderAdmin();
        addArticles();
        frmMain.setVisible(true);
    }
    
    public FrmMain getFrmMain() {
        return frmMain;
    }

    private void addHeaderBtns() {
        JPanel pnlHeaderWriter = frmMain.getPnlHeaderWriter();
        int width = 200, height = 50, margin = 10, order = 0;
        
        JButton btnSeeMyArticles = makeButton("See My Articles", order++, width, height, margin);
        btnSeeMyArticles.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                list all writers articles
            }
        });
        
        JButton btnAddNewArticle = makeButton("Add New Article", order++, width, height, margin);
        btnAddNewArticle.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                ViewCoordinator.getInstance().openAddArticleForm();
            }
        });
        
//        pnlHeaderWriter.add(btnLogin);
        pnlHeaderWriter.add(btnSeeMyArticles);
        pnlHeaderWriter.add(btnAddNewArticle);
                
        
    }
    
    private void addHeaderAdmin() {
        
        JPanel pnlHeaderAdmin = frmMain.getPnlHeaderAdmin();
        int width = 200, height = 20, margin = 4, order = 0;
        
        JButton btnSeeAll = makeButton("See All", order++, width, height, margin);
        btnSeeAll.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                ViewCoordinator.getInstance().openAddArticleForm();
            }
        });
        
        JButton btnSeePublished = makeButton("See Published", order++, width, height, margin);
        btnSeePublished.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                ViewCoordinator.getInstance().openAddArticleForm();
            }
        });
        
        JButton btnSeeDueUnpublished = makeButton("See Due Unpublished", order++, width, height, margin);
        btnSeeDueUnpublished.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                ViewCoordinator.getInstance().openAddArticleForm();
            }
        });
        
        JButton btnSeeUnpublished = makeButton("See Unpublished", order++, width, height, margin);
        btnSeeUnpublished.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                ViewCoordinator.getInstance().openAddArticleForm();
            }
        });
        
        JButton btnAddNewCategory = makeButton("Add New Category", order++, width, height, margin);
        btnAddNewCategory.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
//                ViewCoordinator.getInstance().openAddArticleForm();
            }
        });
        
        
        pnlHeaderAdmin.add(btnSeeAll);
        pnlHeaderAdmin.add(btnSeePublished);
        pnlHeaderAdmin.add(btnSeeDueUnpublished);
        pnlHeaderAdmin.add(btnSeeUnpublished);
        pnlHeaderAdmin.add(btnAddNewCategory);
    }
    
    private JButton makeButton(String title, int order, int width, int height, int margin) {
        JButton btn = new JButton(title);
        btn.setBounds(0, order*(height+margin), width, height);
        
        return btn;
    }
    
    //private void add btn action listeners home, login, search
    //private void fillCbCategories
    
    private void addArticles() {
        JPanel pnlAllArticles = frmMain.getPnlAllArticles();
//        pnlAllArticles.setBackground(Color.BLACK);
        List<Article> articles = new ArrayList<>();
        
        Article a1 = new Article();
        a1.setArticleID(1);
        a1.setTitle("Article no 1, check can it fit if the article is a bit longer and not short like all the others");
        a1.setBody("Sport / Celebrity");
        a1.setWriter("Dominic Thiem");
        
        Article a2 = new Article();
        a2.setArticleID(2);
        a2.setTitle("Article no 2");
        a2.setBody("Sport / Film");
        a2.setWriter("Roger Federer");

        Article a3 = new Article();
        a3.setArticleID(3);
        a3.setTitle("Article no 3");
        a3.setBody("TV / Reality");
        a3.setWriter("Roger Federer");
        
        Article a4 = new Article();
        a4.setArticleID(4);
        a4.setTitle("Article no 4");
        a4.setBody("Animals");
        a4.setWriter("Rafel Nadal");
        
//        articles.add(a1);
//        articles.add(a2);
//        articles.add(a3);
//        articles.add(a4);
        
//      getArticles
        
        for (int i = 0; i < articles.size(); i++) {
            JPanel pnlArticle = makeArticle(articles.get(i));
            pnlArticle.setBounds(pnlAllArticles.getX(), pnlAllArticles.getY()+(i*220), pnlAllArticles.getWidth(), 200);
            pnlAllArticles.add(pnlArticle);
            
        }
        
    }

    private JPanel makeArticle(Article article) {
        JPanel pnlArticle = new JPanel(new BorderLayout());
            
        JLabel lblTitle = new JLabel(article.getTitle(), SwingConstants.CENTER);
        JLabel lblCategory = new JLabel(article.getBody());
        JLabel lblWriter = new JLabel(article.getWriter());
        JButton btnRead = new JButton("Read More");
        btnRead.setPreferredSize(new Dimension(200,35));

        JButton btnEdit = new JButton("Edit");
        btnEdit.setPreferredSize(new Dimension(150,25));
        JButton btnDelete = new JButton("Delete");
        btnDelete.setPreferredSize(new Dimension(150,25));
        
        JButton btnPublish = new JButton("Publish");
        btnPublish.setPreferredSize(new Dimension(150,25));
        JButton btnUnpublish = new JButton("Unpublish");
        btnUnpublish.setPreferredSize(new Dimension(150,25));


        JPanel pnlLeft = new JPanel(new GridBagLayout());
        pnlLeft.setBackground(Color.gray);
        pnlLeft.setPreferredSize(new Dimension(200,200));
        
        JPanel pnlRight = new JPanel(new GridBagLayout());
        pnlRight.setBackground(Color.gray);
        pnlRight.setPreferredSize(new Dimension(200,200));
        
        JPanel pnlCenter = new JPanel(new GridBagLayout());
        pnlCenter.setBackground(Color.white);


        
        addToGBC(pnlLeft, btnEdit, 0, 0, 0);
        addToGBC(pnlLeft, btnDelete, 0, 1, 0);
        
        addToGBC(pnlRight, btnPublish, 0, 0, 0);
        addToGBC(pnlRight, btnUnpublish, 0, 1, 0);
        
        addToGBC(pnlCenter, lblCategory, 0, 0, -1);
        addToGBC(pnlCenter, lblTitle, 1, 1, 0);
        addToGBC(pnlCenter, btnRead, 1, 2, 0);
        addToGBC(pnlCenter, lblWriter, 2, 3, 1);


        pnlArticle.add(pnlLeft, BorderLayout.WEST);
        pnlArticle.add(pnlCenter, BorderLayout.CENTER);
        pnlArticle.add(pnlRight, BorderLayout.EAST);
        
        return pnlArticle;
    }
    
    public void addToGBC(Container parent, Component child, int gridx, int gridy, int anchor) {
        Insets insets = new Insets(25, 5, 0, 5);
        GridBagConstraints c = new GridBagConstraints();
        c.weightx = 1;
        c.gridx = gridx;
        c.gridy = gridy;
        switch (anchor) {
            case -1:
                c.anchor = GridBagConstraints.LINE_START;
                break;
            case 1:
                c.anchor = GridBagConstraints.LINE_END;
                break;
            default:
                c.anchor = GridBagConstraints.CENTER;
                break;
        }
        c.insets = insets;
        
        parent.add(child, c);
    }
    
}
