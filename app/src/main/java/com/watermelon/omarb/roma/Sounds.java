package com.watermelon.omarb.roma;

import android.content.Context;
import android.content.res.Configuration;
import android.widget.Toast;

import java.util.Locale;

public class Sounds {
    private Integer[] arraySound ;

    public void Sounds(){
        arraySound=null;
    }


    public Integer[] getArraySound(String refencia) {

        switch (refencia){
            case "resp_preg_g1_desde":
                arraySound=new Integer[]{R.raw.cabeza_undia,R.raw.cabeza_unasemana,R.raw.cabeza_unmes};
                break;
            case "resp_preg_g2_horario":
                arraySound=new Integer[]{R.raw.cabeza_manana,R.raw.cabeza_tarde,R.raw.cabeza_noche};
                break;
            case "cabeza_resp_sintomas":
                arraySound=new Integer[]{R.raw.cabeza_vertigo,R.raw.cabeza_zumbido,R.raw.motivo_dolor,null};
                break;
            case "cuello_resp_motivos":
                arraySound=new Integer[]{R.raw.cuello_caida,R.raw.cuello_golpes,R.raw.cuello_ejercicios};
                break;
            case "torax_resp_sintomas":
                arraySound=new Integer[]{R.raw.torax_dificultadrespirar,R.raw.torax_tosseca,R.raw.torax_tosexpectorante,R.raw.torax_tosysangrado,R.raw.torax_taquicardia,R.raw.torax_dolorparrillacostal,null};
                break;
            case "resp_tanto_duele":
                arraySound=null;
                break;
            case "resp_duracion_dolor":
                arraySound=new Integer[]{R.raw.abdomen_30minutos,R.raw.abdomen_unahora,R.raw.abdomen_masdeunahora};
                break;
            case "abdomen_resp_aumenta":
                arraySound=new Integer[]{R.raw.abdomen_estardepie,R.raw.abdomen_estarsentado,R.raw.abdomen_encualquierposicion};
                break;
            case "abdomen_resp_disminuye":
                arraySound=new Integer[]{R.raw.abdomen_estardepie,R.raw.abdomen_estarsentado,R.raw.abdomen_encualquierposicion};
                break;
            case "genito_resp_sintomas":
                arraySound=null;
                break;
            case "resp_si_no":
                arraySound=new Integer[]{R.raw.abdomen_si,R.raw.abdomen_no};
                break;
            case "extremidades_resp_motivos":
                arraySound=new Integer[]{R.raw.cuello_caida,R.raw.cuello_golpes,R.raw.cuello_ejercicios};
                break;
            case "fiebre_resp_sintomas":
                arraySound=new Integer[]{R.raw.fiebre_malestargeneral,R.raw.fiebre_pocatoleranciaviaoral};
                break;
            case "fiebre_resp_exposiciones":
                arraySound=new Integer[]{R.raw.fiebre_piquetedezancudo,R.raw.fiebre_piquetedengue};
                break;
            case "nauseas_resp_sintomas":
                arraySound=new Integer[]{R.raw.nauvomi_vomito,R.raw.nauvomi_diarrea,R.raw.nauvomi_dolorabdominal,R.raw.nauvomi_sospechadeembarazo};
                break;
            case "nauseas_resp_habitos":
                arraySound=new Integer[]{R.raw.nauvomi_nocome,R.raw.nauvomi_comemucho};
                break;
            case "diarrea_resp_sintomas":
                arraySound=new Integer[]{R.raw.diarrea_conmoco,R.raw.diarrea_consangre,null,R.raw.diarrea_malolor,null};
                break;

            case "hipertension_resp_alimentacion":
                arraySound=new Integer[]{R.raw.hipertension_buena,R.raw.hipertension_regular,R.raw.hipertension_mala};
                break;

            case "hipertension_resp_consume":
                arraySound=new Integer[]{R.raw.hipertension_muchasal,R.raw.hipertension_pocasal,R.raw.hipertension_nadadesal};
                break;
            case "embarazo_resp_complicaciones":
                arraySound=new Integer[]{R.raw.embarazo_aborto,R.raw.embarazo_prematuro,
                        R.raw.embarazo_nacidovivo,null};
                break;
            case "embarazo_resp_sintomas":
                arraySound=new Integer[]{R.raw.embarazo_sangrado,R.raw.embarazo_percibemovimientosfetales,
                        R.raw.embarazo_dolordecabezayzumbido};
                break;
            case "obesidad_resp_diagnostico_2":
                arraySound=new Integer[]{R.raw.obesidad_nutricional,null,null,null};
                break;


            default:
                    arraySound=null;
                    break;
        }

        return arraySound;
    }

    public String getStringByLocal(Context context, String textid, String locale) {
        String text;
        int id =context.getResources().getIdentifier(textid, "string",
                context.getPackageName());
        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        text = context.createConfigurationContext(configuration).getResources().getString(id);
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        return text;
    }

    public String getStringByLocal(Context context, String textid, String locale,int posicion) {
        String text;
        int id =context.getResources().getIdentifier(textid, "array",
                context.getPackageName());

        Configuration configuration = new Configuration(context.getResources().getConfiguration());
        configuration.setLocale(new Locale(locale));
        //text = context.createConfigurationContext(configuration).getResources().getString(id);
        text = context.createConfigurationContext(configuration).getResources().getStringArray(id)[posicion];
        Toast.makeText(context, text, Toast.LENGTH_LONG).show();
        return text;
    }

    public Integer getSound(String nameSound){
        Integer id;
        switch (nameSound){
            case "preg_g1_desde":
                id=R.raw.cabeza_desdecuando;
                break;
            case "preg_g2_horario":
                id=R.raw.cabeza_enquehorario;
                break;
            case "preg_g3_sintomas":
                id=R.raw.cabeza_otros;
                break;
            case "preg_tanto_duele":
                id =null;
                break;
            case "preg_duracion_dolor":
                id=R.raw.abdomen_duraciondeldolor;
                break;
            case "preg_aumenta_dolor":
                id=R.raw.abdomen_eldoloraunmentaal;
                break;
            case "preg_disminuye_dolor":
                id=R.raw.abdomen_eldolordisminuyeal;
                break;
            case "preg_motivos_dolor":
                id=R.raw.extremidades_motivosdeldolor;
                break;
            case "preg_f_riesgo_fiebre":
                id=R.raw.fiebre_exposicionafactoresderiesgo;
                break;
            case "preg_motpreg_factor_fiebreivos_dolor":
                id=null;
                break;
            case "preg_habitos_nau":
                id=R.raw.nauvomi_alteracionesenhabitosalimenticios;
                break;
            case "preg_n_evacuaciones":
                id=R.raw.diarrea_numerodeevacuacionesaldia;
                break;
            case "preg_fecalismo":
                id=R.raw.diarrea_fecalismoalairelibre;
                break;
            case "diarrea_preg_alim__mal_cocidos":
                id=R.raw.diarrea_consumioalimentosmalcocidos;
                break;
            case "hipertension_preg_fam":
                id=R.raw.hipertension_familiaresconhipertension;
                break;
            case "hipertension_preg_diag":
                id=R.raw.hipertension_esustedhipertenso;
                break;
            case "hipertension_preg_alimentacion":
                id=R.raw.hipertension_comoconsiderasualimentacion;
                break;
            case "hipertension_preg_alimentacion_consume":
                id=R.raw.hipertension_ensusalimentosconsume;
                break;
            case "hipertension_preg_tratamiento":
                id=R.raw.hipertension_cualessutratamientohabitual;
                break;
            case  "hipertension_preg_desde":
                id=R.raw.hipertension_desdecuandoesutedhipertenso;
                break;
            case "obesidad_preg_fam":
                id=R.raw.obesidad_familiaresconobesidad;
                break;
            case "obesidad_preg_diag":
                id=R.raw.obesidad_esustedsedentario;
                break;
            case "obesidad_preg_alimentacion":
                id=R.raw.obesidad_comoconsiderasualimentacion;
                break;
            case "diabetes_preg_fam":
                id=R.raw.diabetes_familiarescondiabetes;
                break;
            case "diabetes_preg_diag":
                id=R.raw.diabetes_esustediabetico;
                break;
            case "diabetes_preg_alimentacion":
                id=R.raw.diabetes_comoconsiderasualimentacion;
                break;
            case "diabetes_preg_tratamiento":
                id=R.raw.diabetes_cualessutratamiento;
                break;
            case "diabetes_preg_desde":
                id=R.raw.diabetes_desdehacecuantoesusteddiabetico;
                break;
            case "preg_embarazo_inicio_vida":
                id=R.raw.embarazo_iniciodevidasexual;
                break;
            case "preg_embarazo_ultima_regla":
                id=R.raw.embarazo_fechadeultimaregla;
                break;
            case "preg_embarazo_otros_embarazos":
                id=null;
                break;
            case "preg_embarazo_complicaciones":
                id=null;
                break;
            case "preg_embarazo_acido_folico":
                id=R.raw.embarazo_tomaacidofolico;
                break;
        default:
            id=null;
            break;
    }
    return id;
    }
}
