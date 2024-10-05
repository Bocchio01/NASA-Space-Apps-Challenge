package models.record;

import utils.Constants;

public record PlanetRecord(
        Integer ID) {

    @Override
    public String toString() {
        String[] dataStrings = new String[] {
                ID.toString()                
        };

        return String.join(Constants.SEPARATOR, dataStrings);
    }
}


// kepid
// kepoi_name
// kepler_name
// koi_disposition
// koi_pdisposition
// koi_score
// koi_fpflag_nt
// koi_fpflag_ss
// koi_fpflag_co
// koi_fpflag_ec
// koi_period
// koi_period_err1
// koi_period_err2
// koi_time0bk
// koi_time0bk_err1
// koi_time0bk_err2
// koi_impact
// koi_impact_err1
// koi_impact_err2
// koi_duration
// koi_duration_err1
// koi_duration_err2
// koi_depth
// koi_depth_err1
// koi_depth_err2
// koi_prad
// koi_prad_err1
// koi_prad_err2
// koi_teq
// koi_teq_err1
// koi_teq_err2
// koi_insol
// koi_insol_err1
// koi_insol_err2
// koi_model_snr
// koi_tce_plnt_num
// koi_tce_delivname
// koi_steff
// koi_steff_err1
// koi_steff_err2
// koi_slogg
// koi_slogg_err1
// koi_slogg_err2
// koi_srad
// koi_srad_err1
// koi_srad_err2
// ra_str
// dec_str
// koi_kepmag
// koi_kepmag_err