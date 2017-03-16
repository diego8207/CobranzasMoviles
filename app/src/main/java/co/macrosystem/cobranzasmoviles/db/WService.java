package co.macrosystem.cobranzasmoviles.db;


/**
 * Created by Diego Velez on 02/03/2017.
 */

public class WService {
    // Método que queremos ejecutar en el servicio web
    public static final String Metodo = "ConsultarUsuarios";
    public static final String MetodoLogin = "ConsultarUsuario";
    // Namespace definido en el servicio web
    public static final String namespace = "http://webservices/";
    // namespace + metodo
    public static final String accionSoap = "http://webservices//ConsultarUsuarios";
    // Fichero de definicion del servcio web
    public static final String url = "http://192.168.1.6:8090/WSUsuario/WSGestionUsuario?wsdl";
    private boolean boolres = false;
/*
    public boolean invoceWS() {
        boolean res = false;
        try {
            SoapObject request = new SoapObject(namespace, Metodo);
            SoapSerializationEnvelope sobre = new SoapSerializationEnvelope(SoapEnvelope.VER11);
            //sobre.dotNet = true;
            sobre.setOutputSoapObject(request);
            HttpTransportSE transporte = new HttpTransportSE(url);
            transporte.call(accionSoap, sobre);    // Llamada
            Vector<?> responseVector = null;
            SoapObject soapObject = null;
            List<Suspension> listaSusp = new ArrayList<>();
            if (sobre.getResponse() instanceof Vector)
                responseVector = (Vector<?>) sobre.getResponse();//almacenar en vector
            else
                soapObject = (SoapObject) sobre.getResponse();
            if (responseVector != null) {
                int count = responseVector.size();
                for (int i = 0; i < count; ++i) { //Cada registro encontrado
                    SoapObject test = (SoapObject) responseVector.get(i);
                    listaSusp.add(leerSoap(test));
                }
            } else {
                if (soapObject != null)
                    listaSusp.add(leerSoap(soapObject));
            }
        } catch (SoapFault soapFault) {
            soapFault.printStackTrace();
        } catch (XmlPullParserException e) {
            e.printStackTrace();
        } catch (SocketTimeoutException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return res;
    }

    private Suspension leerSoap(SoapObject soapObj) {
        String matricula = soapObj.getProperty("SUSP_MATRICULA").toString();
        String proceso = soapObj.getProperty("SUSP_NUM_PROCESO").toString();
        String medidor = soapObj.getProperty("SUSP_NUM_MEDIDOR").toString();
        Suspension suspension = new Suspension();
        suspension.setSUSP_MATRICULA(matricula);
        suspension.setSUSP_NUM_PROCESO(proceso);
        suspension.setSUSP_NUM_MEDIDOR(medidor);

        return suspension;
    }


*/
}