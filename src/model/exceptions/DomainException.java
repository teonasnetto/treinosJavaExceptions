package model.exceptions;

//extends de Exception para obrigar a  ser tratato
//extends de RunTimeException para não obrigar ser tratato, o compilador não irá "reclamar"
public class DomainException extends Exception {
    //necessário para versionar uma Exception
    private static final long serialVersionUID = 1L;

    public DomainException(String msg) {
        super(msg);
    }

}
