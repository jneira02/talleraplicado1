
/**
 * ServicioWebCallbackHandler.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis2 version: 1.6.2  Built on : Apr 17, 2012 (05:33:49 IST)
 */

    package webservice;

    /**
     *  ServicioWebCallbackHandler Callback class, Users can extend this class and implement
     *  their own receiveResult and receiveError methods.
     */
    public abstract class ServicioWebCallbackHandler{



    protected Object clientData;

    /**
    * User can pass in any object that needs to be accessed once the NonBlocking
    * Web service call is finished and appropriate method of this CallBack is called.
    * @param clientData Object mechanism by which the user can pass in user data
    * that will be avilable at the time this callback is called.
    */
    public ServicioWebCallbackHandler(Object clientData){
        this.clientData = clientData;
    }

    /**
    * Please use this constructor if you don't want to set any clientData
    */
    public ServicioWebCallbackHandler(){
        this.clientData = null;
    }

    /**
     * Get the client data
     */

     public Object getClientData() {
        return clientData;
     }

        
           /**
            * auto generated Axis2 call back method for mostrarClientesConsumos method
            * override this method for handling normal response from mostrarClientesConsumos operation
            */
           public void receiveResultmostrarClientesConsumos(
                    webservice.ServicioWebStub.MostrarClientesConsumosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from mostrarClientesConsumos operation
           */
            public void receiveErrormostrarClientesConsumos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for mostrarClientesHistoricos method
            * override this method for handling normal response from mostrarClientesHistoricos operation
            */
           public void receiveResultmostrarClientesHistoricos(
                    webservice.ServicioWebStub.MostrarClientesHistoricosResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from mostrarClientesHistoricos operation
           */
            public void receiveErrormostrarClientesHistoricos(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for registrarAdministrador method
            * override this method for handling normal response from registrarAdministrador operation
            */
           public void receiveResultregistrarAdministrador(
                    webservice.ServicioWebStub.RegistrarAdministradorResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from registrarAdministrador operation
           */
            public void receiveErrorregistrarAdministrador(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for registrarCuenta method
            * override this method for handling normal response from registrarCuenta operation
            */
           public void receiveResultregistrarCuenta(
                    webservice.ServicioWebStub.RegistrarCuentaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from registrarCuenta operation
           */
            public void receiveErrorregistrarCuenta(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for registrarCliente method
            * override this method for handling normal response from registrarCliente operation
            */
           public void receiveResultregistrarCliente(
                    webservice.ServicioWebStub.RegistrarClienteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from registrarCliente operation
           */
            public void receiveErrorregistrarCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for registrarConsumo method
            * override this method for handling normal response from registrarConsumo operation
            */
           public void receiveResultregistrarConsumo(
                    webservice.ServicioWebStub.RegistrarConsumoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from registrarConsumo operation
           */
            public void receiveErrorregistrarConsumo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for desactivarCuenta method
            * override this method for handling normal response from desactivarCuenta operation
            */
           public void receiveResultdesactivarCuenta(
                    webservice.ServicioWebStub.DesactivarCuentaResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from desactivarCuenta operation
           */
            public void receiveErrordesactivarCuenta(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modificarCliente method
            * override this method for handling normal response from modificarCliente operation
            */
           public void receiveResultmodificarCliente(
                    webservice.ServicioWebStub.ModificarClienteResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modificarCliente operation
           */
            public void receiveErrormodificarCliente(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for modificarConsumo method
            * override this method for handling normal response from modificarConsumo operation
            */
           public void receiveResultmodificarConsumo(
                    webservice.ServicioWebStub.ModificarConsumoResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from modificarConsumo operation
           */
            public void receiveErrormodificarConsumo(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for mostrarClientes method
            * override this method for handling normal response from mostrarClientes operation
            */
           public void receiveResultmostrarClientes(
                    webservice.ServicioWebStub.MostrarClientesResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from mostrarClientes operation
           */
            public void receiveErrormostrarClientes(java.lang.Exception e) {
            }
                
           /**
            * auto generated Axis2 call back method for logear method
            * override this method for handling normal response from logear operation
            */
           public void receiveResultlogear(
                    webservice.ServicioWebStub.LogearResponse result
                        ) {
           }

          /**
           * auto generated Axis2 Error handler
           * override this method for handling error response from logear operation
           */
            public void receiveErrorlogear(java.lang.Exception e) {
            }
                


    }
    