package report;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import net.sf.jasperreports.engine.util.JRLoader;

public class Relatorio {

	private HttpServletResponse response;
	private FacesContext context;

	public Relatorio() {
		this.context = FacesContext.getCurrentInstance();
		this.response = (HttpServletResponse) this.context.getExternalContext().getResponse();
	}

	public void gerarRelatorio(List<?> lista) throws JRException, IOException {
		InputStream stream = this.getClass().getResourceAsStream("listagemProdutos.jasper");
		Map<String, Object> params = new HashMap<>();
		ByteArrayOutputStream baos = new ByteArrayOutputStream();

		JRBeanCollectionDataSource dataSource = new JRBeanCollectionDataSource(lista);

		JasperReport jasper = (JasperReport) JRLoader.loadObject(stream);
		JasperPrint print = JasperFillManager.fillReport(jasper, params, dataSource);
		JasperExportManager.exportReportToPdfStream(print,baos);
		
		response.reset();	
		response.setContentType("application/pdf");
		response.setContentLength(baos.size());
		response.setHeader("Content-disposition","inline; filename=relatorio.pdf");
		response.getOutputStream().write(baos.toByteArray());	
		response.getOutputStream().flush();	
		response.getOutputStream().close();		
		context.responseComplete();
	}
}
