package Controller;

import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import com.itextpdf.text.Document;
import com.itextpdf.text.DocumentException;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Font.FontFamily;
import com.itextpdf.text.PageSize;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;

import Model.Departamento;
import Model.DepartamentoDAO;
import Model.Equipamento;
import Model.EquipamentoDAO;
import Model.Evento;
import Model.EventoDAO;
import Model.Pesquisador;
import Model.PesquisadorDAO;
import Model.Projeto;
import Model.ProjetoDAO;

public class GerarPDF {

	private Document doc;
	private FileOutputStream fos;
	private Paragraph title;
	private String path;

	public GerarPDF(BancoDeDados banco, String path) {
		if (path.endsWith(".pdf"))
			this.path = path;
		else
			this.path = path + ".pdf";
	}

	public void gerarRelatorioPesquisador() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados ICT Lab", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela de Pesquisadores", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable pesquisadorTable = new PdfPTable(new float[] { 0.1f, 0.1f, 0.1f, 0.1f, 0.1f, 0.1f });
		pesquisadorTable.setWidthPercentage(130.0f);
		pesquisadorTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		pesquisadorTable.setSpacingBefore(20);
		pesquisadorTable.addCell("Nome");
		pesquisadorTable.addCell("Email");
		pesquisadorTable.addCell("Biografia");
		pesquisadorTable.addCell("Lattes");
		pesquisadorTable.addCell("LinkedIN");
		pesquisadorTable.addCell("Login");		

		ArrayList<Pesquisador> pesquisador = PesquisadorDAO.getInstance().getPDFAllPesquisadores();

		for (Pesquisador p : pesquisador) {
			pesquisadorTable.addCell(p.getNome());
			pesquisadorTable.addCell(p.getEmail());
			pesquisadorTable.addCell(p.getBiografia());
			pesquisadorTable.addCell(p.getLattes());
			pesquisadorTable.addCell(p.getLinkedin());
			System.out.println(p.getLoginUser().getLogin());
			pesquisadorTable.addCell(p.getLoginUser().getLogin());
			
		}

		doc.add(pesquisadorTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}

	public void gerarRelatorioDepartamento() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados ICT Lab", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela dos Departamentos", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable departamentoTable = new PdfPTable(new float[] { 0.1f, 0.1f, 0.1f });
		departamentoTable.setWidthPercentage(130.0f);
		departamentoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		departamentoTable.setSpacingBefore(20);
		departamentoTable.addCell("Nome");
		departamentoTable.addCell("Responsavel");
		departamentoTable.addCell("Descrição");

		ArrayList<Departamento> departamento = DepartamentoDAO.getInstance().getPDFAllDepartamentos();

		for (Departamento d : departamento) {
			departamentoTable.addCell(d.getNome());
			departamentoTable.addCell(d.getResponsavel());
			departamentoTable.addCell(d.getDescricao());	
		}

		doc.add(departamentoTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}
	
	public void gerarRelatorioEvento() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados ICT Lab", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela dos Eventos", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable eventoTable = new PdfPTable(new float[] { 0.1f, 0.1f, 0.1f, 0.1f });
		eventoTable.setWidthPercentage(130.0f);
		eventoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		eventoTable.setSpacingBefore(20);
		eventoTable.addCell("Nome");
		eventoTable.addCell("Responsavel");
		eventoTable.addCell("Data");
		eventoTable.addCell("Local");

		ArrayList<Evento> evento = EventoDAO.getInstance().getPDFAllEvento();

		for (Evento e : evento) {
			eventoTable.addCell(e.getNome());
			eventoTable.addCell(e.getResponsavel());
			eventoTable.addCell(e.getData());	
			eventoTable.addCell(e.getLocal());
		}

		doc.add(eventoTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}
	
	public void gerarRelatorioEquipamento() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados ICT Lab", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela dos Equipamentos", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable equipamentoTable = new PdfPTable(new float[] { 0.1f, 0.1f, 0.1f});
		equipamentoTable.setWidthPercentage(130.0f);
		equipamentoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		equipamentoTable.setSpacingBefore(20);
		equipamentoTable.addCell("Nome");
		equipamentoTable.addCell("Tombo");
		equipamentoTable.addCell("Descrição");

		ArrayList<Equipamento> equipamento = EquipamentoDAO.getInstance().getPDFAllEquipamento();

		for (Equipamento e : equipamento) {
			equipamentoTable.addCell(e.getNome());
			equipamentoTable.addCell(e.getTombo());
			equipamentoTable.addCell(e.getDescricao());	
		}

		doc.add(equipamentoTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}
	
	public void gerarRelatorioProjeto() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados ICT Lab", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela dos Projetos", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable projetoTable = new PdfPTable(new float[] { 0.1f, 0.1f});
		projetoTable.setWidthPercentage(130.0f);
		projetoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		projetoTable.setSpacingBefore(20);
		projetoTable.addCell("Nome");
		projetoTable.addCell("Status do Projeto");

		ArrayList<Projeto> projeto = ProjetoDAO.getInstance().getPDFAllProjeto();

		for (Projeto p : projeto) {
			projetoTable.addCell(p.getNome());
			projetoTable.addCell(p.getStatusDoProjeto());	
		}

		doc.add(projetoTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}
	
	
	
	
	
	

}
