package com.br.everis.homeoffice.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.Normalizer;
import java.text.NumberFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.Random;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.tomcat.util.http.fileupload.FileUtils;

/**
 * @author alan.franco
 *
 */
public final class MetodosUteis {

	private static final String HTTP = "http://";
	private static final String HTTPS = "https://";

	public MetodosUteis() {
		super();
	}

	public static String formatDateToString(Date date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
		return dateFormat.format(date);
	}

	public static Date formatStringToDate(String dateString) {
		DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
		Date date = null;
		try {
			date = format.parse(dateString);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return date;
	}

	public static String formatCharactersFromDate(String dateString) {
		String finalString = null;
		if (dateString != null) {
			finalString = dateString.replaceAll("\\D", "/");
		}
		return finalString;
	}

	public static String formatDateAndTimeToString(Date date) {
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");
		return dateFormat.format(date);
	}

	public static String formatDateToString(Date date, String pattern) {
		SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
		return dateFormat.format(date);
	}

	@SuppressWarnings("deprecation")
	public static Date formatStringToDayAndTime(String date) {
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd.hh:mm:ss");
		Date data = new Date();
		try {
			data = dateFormat.parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return new Date(data.getDay() + data.getTime());
	}

	public static String formatDateToStringForNameFile(Date date, boolean minutesAndSeconds) {
		SimpleDateFormat dateFormat = new SimpleDateFormat((minutesAndSeconds) ? "yyyyMMddHHmmss" : "yyyyMMdd");
		return dateFormat.format(date);
	}

	public static String getFormatNamePDFRegularizationAR(String name) {
		return formatDateToStringForNameFile(new Date(), true) + "_" + name;
	}

	public static Integer getMonthOfDate(Date date) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		return gregorianCalendar.get(Calendar.MONTH) + 1;
	}

	public static Integer getYearOfDate(Date date) {
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(date);
		return gregorianCalendar.get(Calendar.YEAR);
	}

	public static int getDaysSubtractionDates(Date initialDate, Date finalDate) {
		/* Retorna a quantidade de dias de um intervalo de datas */
		if ((initialDate == null) || (finalDate == null)) {
			return 0;
		}
		int days = (int) ((finalDate.getTime() - initialDate.getTime()) / (24 * 60 * 60 * 1000));
		return days > 0 ? days : 0;
	}

	public static int getWorkingDays(Date initialDate, Date finalDate) {
		int workingDays = 0;
		int totalDays = getDaysSubtractionDates(initialDate, finalDate);
		GregorianCalendar gregorianCalendar = new GregorianCalendar();
		gregorianCalendar.setTime(finalDate);
		for (int i = 0; i <= totalDays; i++) {
			if (!(gregorianCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY)
					&& !(gregorianCalendar.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY)) {
				workingDays++;
			}
			gregorianCalendar.add(Calendar.DATE, 1);
		}
		return workingDays;
	}

	public static String formatZipCode(String zipCode) {
		if (zipCode.trim().length() != 8) {
			return "";

		}
		return zipCode.substring(0, 2) + "." + zipCode.substring(2, 5) + "-" + zipCode.substring(5, 8);
	}

	public static String formatZipCode9(String zipCode) {
		if (zipCode.trim().length() != 8) {
			return "";

		}
		return zipCode.substring(0, 5) + "-" + zipCode.substring(5, 8);
	}

	public static String formatLongNumberToString(Number number) {
		NumberFormat numberFormat = NumberFormat.getNumberInstance(new Locale("pt", "BR"));
		return numberFormat.format(number);
	}

	public static String formatNumberTwoDigits(Integer value) {
		if (value == null) {
			value = 0;
		}

		DecimalFormat df = new DecimalFormat("#######0.00");
		return df.format(Double.valueOf(value.toString()) / 1000L).replace(",", ".");
	}

	public static String formatNumberOneDigit(Integer value) {
		if (value == null) {
			value = 0;
		}
		DecimalFormat df = new DecimalFormat("####0.0");
		return df.format(Double.valueOf(value.toString()) / 1000L).replace(",", ".");
	}

	private static String getIntegerFormat(int numberOfDigits) {
		String format = "";
		for (int countDigit = 0; countDigit < numberOfDigits; countDigit++) {
			format += "0";
		}
		return format;
	}

	public static String formatNumberDigits(Long number, int numberOfDigits) {
		DecimalFormat decimalFormat = new DecimalFormat(getIntegerFormat(numberOfDigits));
		return decimalFormat.format(number);
	}

	public static String getRandomNumber() {
		Random gerador = new Random();
		String number = "";
		for (int i = 0; i < 10; i++) {
			number += Integer.toString(gerador.nextInt(10));
		}
		return number.trim();
	}

	public static String convertGramToKilogram(Double gram) {
		String kilogram = null;
		if (gram != null) {
			Double kg = gram / 1000;
			kilogram = kg.toString();
		}
		return kilogram;
	}

	public static Boolean convertStringWsValueToBoolean(String wsValue) {
		Boolean booleanValue = null;
		if ("S".equals(wsValue)) {
			booleanValue = Boolean.TRUE;
		}
		if ("N".equals(wsValue)) {
			booleanValue = Boolean.FALSE;
		}
		return booleanValue;
	}

	public static String convertBooleanToWsValue(Boolean value) {
		String wsValue = null;
		if (value) {
			wsValue = "S";
		} else {
			wsValue = "N";
		}
		return wsValue;
	}

	public static BigDecimal convertDoubleToBigDecimal(Double number) {
		BigDecimal bigDecNumber = null;
		if (number != null) {
			bigDecNumber = new BigDecimal(number);
		}
		return bigDecNumber;
	}

	public static List<Integer> convertStringInIntegerList(String string) {
		List<Integer> returnList = new ArrayList<>();
		String finalString = replaceAllSeparatosCharactersForComma(string);
		if (finalString != null) {
			List<String> stringList = new ArrayList<>(Arrays.asList(finalString.split(",")));
			for (String s : stringList) {
				returnList.add(Integer.valueOf(s));
			}
		}
		return returnList;
	}

	public static String replaceAllSeparatosCharactersForComma(String string) {
		String finalString = null;
		if (string != null) {
			finalString = string.replaceAll("\r\n", ",").replaceAll("\n", ",").replaceAll("\r", ",")
					.replaceAll("\t", ",").replaceAll(",,", ",").replaceAll(";,", ",").replaceAll(",;", ",")
					.replaceAll(";", ",").replaceAll("\\.", ",").replaceAll(" ", ",");
		}
		return finalString;
	}

	public static String replaceAllSeparatorsCharactersForTrace(String string) {
		String finalString = null;
		if (string != null) {
			finalString = string.replaceAll("\r\n", "-").replaceAll("\n", "-").replaceAll("\r", "-")
					.replaceAll("\t", "-").replaceAll(",,", "-").replaceAll(";,", "-").replaceAll(",;", "-")
					.replaceAll(";", "-").replaceAll("\\.", "-").replaceAll(" ", "-").replaceAll(",", "-");
		}
		return finalString;
	}

	public static String removeAllSpecialsCharacters(String string) {
		String finalString = null;
		if (string != null) {
			finalString = Normalizer.normalize(string, Normalizer.Form.NFD).replaceAll("[^\\p{ASCII}]", "");
		}
		return finalString;
	}

	public static boolean equalsIgnoreCaseAndSpecialCharacters(String arg1, String arg2) {
		if (arg1 == null || arg2 == null)
			return false;
		return removeAllSpecialsCharacters(arg1).equalsIgnoreCase(removeAllSpecialsCharacters(arg2));
	}

	public static String removeAllLessNumbers(String string) {
		String finalString = null;
		if (string != null) {
			finalString = string.replaceAll("\\D", "");
		}
		return finalString;
	}

	public static String regexToRemoveSpecialCharactersLessTraces(String string) {
		String finalString = null;
		if (string != null) {
			finalString = string.replaceAll("[^a-zA-Z1-9_-]", "");
		}
		return finalString;
	}

	public static void ziparPasta(String caminhoArq, String destinoArquivoZipado) throws Exception {
		ZipOutputStream zip = null;

		try {
			FileOutputStream fileWriter = null;
			fileWriter = new FileOutputStream(destinoArquivoZipado);
			zip = new ZipOutputStream(new BufferedOutputStream(fileWriter));

			adicionarArquivosNoZip("", caminhoArq, zip);
		} catch (Exception e) {
			throw e;
		} finally {
			if (zip != null) {
				zip.flush();
				zip.close();
			}
		}
	}

	private static void adicionarArquivosNoZip(String path, String srcFile, ZipOutputStream zip) throws Exception {
		FileInputStream in = null;

		try {
			File folder = new File(srcFile);

			if (folder.isDirectory()) {
				adicionarPastaNoZip(path, srcFile, zip);
			} else {
				byte[] buf = new byte[1024];
				int len;
				in = new FileInputStream(srcFile);

				if (!path.equals(""))
					zip.putNextEntry(new ZipEntry(path + "/" + folder.getName()));
				else
					zip.putNextEntry(new ZipEntry(folder.getName()));

				while ((len = in.read(buf)) > 0) {
					zip.write(buf, 0, len);
				}
			}
		} catch (Exception e) {
			throw e;
		} finally {
			if (in != null)
				in.close();
		}
	}

	private static void adicionarPastaNoZip(String path, String srcFolder, ZipOutputStream zip) throws Exception {
		File folder = new File(srcFolder);

		for (String fileName : folder.list()) {
			if (path.equals("")) {
				adicionarArquivosNoZip(folder.getName(), srcFolder + "/" + fileName, zip);
			} else {
				adicionarArquivosNoZip(path + "/" + folder.getName(), srcFolder + "/" + fileName, zip);
			}
		}
	}

	public static void descompactarArquivoZip(String caminhoArqZip, String localParaDescompactar) throws IOException {
		InputStream arqZip = new FileInputStream(caminhoArqZip);
		ZipInputStream zip = new ZipInputStream(arqZip);

		try {
			ZipEntry entry;
			while ((entry = zip.getNextEntry()) != null) {
				if (!localParaDescompactar.endsWith("/"))
					localParaDescompactar += "/";

				if (entry.isDirectory()) {
					(new File(localParaDescompactar + entry.getName())).mkdir();
					continue;
				}

				FileOutputStream out = null;
				try {
					out = new FileOutputStream(localParaDescompactar + entry.getName());

					byte[] b = new byte[512];
					int len = 0;

					while ((len = zip.read(b)) != -1) {
						out.write(b, 0, len);
					}

				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					if (out != null)
						out.close();
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			if (zip != null)
				zip.close();
		}
	}

	public static void gerarEstruturaPasta(String caminho, boolean deletarPastaExistente) throws Exception {
		try {
			if (!caminho.endsWith("/"))
				caminho += "/";

			File diretorioRaiz = new File(caminho);
			if (deletarPastaExistente && diretorioRaiz.exists())
				FileUtils.forceDelete(diretorioRaiz);

			diretorioRaiz.mkdirs();
		} catch (Exception e) {
			throw e;
		}
	}

	public static String recuperarCaminhoPelaUrl(String url) throws Exception {
		try {
			url = url.contains(HTTP) ? url.substring(url.indexOf(HTTP) + HTTP.length(), url.length())
					: url.substring(url.indexOf(HTTPS) + HTTPS.length(), url.length());

			url = url.substring(url.indexOf("/") + 1, url.length());

			return url;
		} catch (Exception e) {
			throw e;
		}
	}

	public static void gerarArquivo(String caminho, String nomeArq, String script) throws Exception {
		try {
			File arq = new File("src/main/resources/" + caminho + nomeArq);

			arq.createNewFile();
			PrintWriter gravarArq = new PrintWriter(arq);
			gravarArq.printf(script);
			gravarArq.close();
		} catch (Exception e) {
			throw e;
		}
	}

	public static StringBuilder gerarCabecalhoScript() throws Exception {
		try {
			StringBuilder buffer = new StringBuilder();

			buffer.append("SET DEFINE OFF; \n");
			buffer.append("SET SERVEROUTPUT ON \n");
			buffer.append("DECLARE VERRO VARCHAR2(2000); \n");
			buffer.append("BEGIN \n\n");
			buffer.append("DBMS_OUTPUT.PUT_LINE('INICIO SCRIPT - DEMANDA @confsite;'); \n\n");

			return buffer;
		} catch (Exception e) {
			throw e;
		}
	}

	public static StringBuilder gerarRodapeScript() throws Exception {
		try {
			StringBuilder buffer = new StringBuilder();

			buffer.append("COMMIT; \n\n");
			buffer.append("EXCEPTION \n");
			buffer.append("WHEN OTHERS THEN \n");
			buffer.append("VERRO := VERRO || '****************** Erro ****************  ' || CHR(13) || \n");
			buffer.append("DBMS_UTILITY.FORMAT_ERROR_STACK; \n");
			buffer.append("VERRO := VERRO || '****************** Linha ***************  ' || CHR(13) || \n");
			buffer.append("DBMS_UTILITY.FORMAT_ERROR_BACKTRACE; ");
			buffer.append("VERRO := VERRO || '**************** Detalhes **************  ' || CHR(13) || \n");
			buffer.append("DBMS_UTILITY.FORMAT_CALL_STACK; \n");
			buffer.append("VERRO := VERRO || '****************************************  '; \n");
			buffer.append("DBMS_OUTPUT.PUT_LINE(VERRO); -- OUTPUT COM O ERRO CAPTURADO. \n\n");
			buffer.append("ROLLBACK; -- EM CASO DE ERRO, APLICAR ROLLBACK. \n\n");
			buffer.append("END; \n");
			buffer.append("/");

			return buffer;
		} catch (Exception e) {
			throw e;
		}
	}

}
