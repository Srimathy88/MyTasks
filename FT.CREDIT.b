SUBROUTINE FT.CREDIT
*-----------------------------------------------------------------------------
*
*-----------------------------------------------------------------------------
* Modification History :
*-----------------------------------------------------------------------------

*-----------------------------------------------------------------------------
    $INSERT I_COMMON
    $INSERT I_EQUATE
    $INSERT I_F.ACCOUNT
    $INSERT I_F.FUNDS.TRANSFER
    
    GOSUB CREDIT
    
    CREDIT:
    FC.NAME="F.ACCOUNT"
    FC.PATH=""
    CALL OPF(FC.NAME,FC.PATH)
    CREDIT.ACC=R.NEW(FT.CREDIT.ACCT.NO)
    CALL F.READ(FC.NAME,CREDIT.ACC,RECORD.FC,FC.PATH,ERR1)
    R.NEW(FT.CREDIT.CURRENCY)=RECORD.FC<AC.CURRENCY>
RETURN
    
END
