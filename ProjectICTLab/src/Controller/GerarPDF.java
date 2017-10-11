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
import Model.Pesquisador;
import Model.PesquisadorDAO;

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

		PdfPTable pesquisadorTable = new PdfPTable(new float[] { 0.1f, 0.1f, 0.1f, 0.1f, 0.1f });
		pesquisadorTable.setWidthPercentage(130.0f);
		pesquisadorTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		pesquisadorTable.setSpacingBefore(20);
		pesquisadorTable.addCell("Nome");
		pesquisadorTable.addCell("Email");
		pesquisadorTable.addCell("Biografia");
		pesquisadorTable.addCell("Lattes");
		pesquisadorTable.addCell("LinkedIN");

		ArrayList<Pesquisador> pesquisador = PesquisadorDAO.getInstance().getPDFAllPesquisadores();

		for (Pesquisador p : pesquisador) {
			pesquisadorTable.addCell(p.getNome());
			pesquisadorTable.addCell(p.getEmail());
			pesquisadorTable.addCell(p.getBiografia());
			pesquisadorTable.addCell(p.getLattes());
			pesquisadorTable.addCell(p.getLinkedin());
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
			departamentoTable.addCell(d.getDescricao());
			departamentoTable.addCell(d.getResponsavel());
		}

		doc.add(departamentoTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}
	
	public void gerarRelatorioInimigos() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		// Image logo = Image.getInstance("src/Imagens/cadastrarUsuario.png");
		// logo.setAlignment(Element.ALIGN_CENTER);
		// doc.add(logo);

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados MarioGO", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela Inimigos do Mário", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable inimigoTable = new PdfPTable(new float[] { 0.1f, 0.1f, 0.1f });
		inimigoTable.setWidthPercentage(130.0f);
		inimigoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		inimigoTable.setSpacingBefore(20);
		inimigoTable.addCell("Nome");
		inimigoTable.addCell("Habilidade");
		inimigoTable.addCell("Historia");

		ArrayList<Inimigo> inimigo = InimigoDAO.getInstance().getPDFAllInimigos();

		for (Inimigo i : inimigo) {
			inimigoTable.addCell(i.getNome());
			inimigoTable.addCell(i.getHabilidade());
			inimigoTable.addCell(i.getHistoria());
		}

		doc.add(inimigoTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}
	
	public void gerarRelatorioPoder() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		// Image logo = Image.getInstance("src/Imagens/cadastrarUsuario.png");
		// logo.setAlignment(Element.ALIGN_CENTER);
		// doc.add(logo);

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados MarioGO", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela dos Poderes", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable poderTable = new PdfPTable(new float[] { 0.1f, 0.1f});
		poderTable.setWidthPercentage(130.0f);
		poderTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		poderTable.setSpacingBefore(20);
		poderTable.addCell("Nome");
		poderTable.addCell("Efeito");

		ArrayList<Poder> poder = PoderDAO.getInstance().getPDFAllPoder();

		for (Poder p : poder) {
			poderTable.addCell(p.getNome());
			poderTable.addCell(p.getEfeito());
		}

		doc.add(poderTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}
	
	public void gerarRelatorioRegiao() throws MalformedURLException, IOException, DocumentException {
		doc = new Document(PageSize.A4, 72, 72, 72, 72);
		fos = new FileOutputStream(path);
		PdfWriter.getInstance(doc, fos);
		doc.open();

		// Image logo = Image.getInstance("src/Imagens/cadastrarUsuario.png");
		// logo.setAlignment(Element.ALIGN_CENTER);
		// doc.add(logo);

		Font fonte = new Font(FontFamily.UNDEFINED, 20, Font.BOLD);
		title = new Paragraph("Tabelas do Banco de Dados MarioGO", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		fonte.setSize(12);
		title = new Paragraph("Tabela das Regiões", fonte);
		title.setAlignment(Element.ALIGN_CENTER);
		title.setSpacingBefore(30);
		doc.add(title);

		PdfPTable regiaoTable = new PdfPTable(new float[] { 0.1f, 0.1f});
		regiaoTable.setWidthPercentage(130.0f);
		regiaoTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		regiaoTable.setSpacingBefore(20);
		regiaoTable.addCell("Nome");
		regiaoTable.addCell("Descrição");

		ArrayList<Regiao> regiao = RegiaoDAO.getInstance().getPDFAllRegiao();

		for (Regiao r : regiao) {
			regiaoTable.addCell(r.getNome());
			regiaoTable.addCell(r.getDescricao());
		}

		doc.add(regiaoTable);

		JOptionPane.showMessageDialog(null, "Relatório gerado com Sucesso!", "Sucesso!",
				JOptionPane.INFORMATION_MESSAGE);
		if (doc != null)
			doc.close();
		if (fos != null)
			fos.close();
	}

}
