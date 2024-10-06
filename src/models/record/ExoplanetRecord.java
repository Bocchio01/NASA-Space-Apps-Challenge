package models.record;

import java.util.List;

import utils.Constants;

public record ExoplanetRecord(
        Integer ID,
        String name, // name
        String planet_status, // planet_status
        Double mass, // mass
        // Double mass_error_min, // mass_error_min
        // Double mass_error_max, // mass_error_max
        // Double mass_sini, // mass_sini
        // Double mass_sini_error_min, // mass_sini_error_min
        // Double mass_sini_error_max, // mass_sini_error_max
        Double radius, // radius
        // Double radius_error_min, // radius_error_min
        // Double radius_error_max, // radius_error_max
        Double orbital_period, // orbital_period
        // Double orbital_period_error_min, // orbital_period_error_min
        // Double orbital_period_error_max, // orbital_period_error_max
        Double semi_major_axis, // semi_major_axis
        // Double semi_major_axis_error_min, // semi_major_axis_error_min
        // Double semi_major_axis_error_max, // semi_major_axis_error_max
        Double eccentricity, // eccentricity
        // Double eccentricity_error_min, // eccentricity_error_min
        // Double eccentricity_error_max, // eccentricity_error_max
        Double inclination, // inclination
        // Double inclination_error_min, // inclination_error_min
        // Double inclination_error_max, // inclination_error_max
        Double angular_distance, // angular_distance
        Integer discovered, // discovered
        String updated, // updated
        Double omega, // omega
        // Double omega_error_min, // omega_error_min
        // Double omega_error_max, // omega_error_max
        // Double tperi, // tperi
        // Double tperi_error_min, // tperi_error_min
        // Double tperi_error_max, // tperi_error_max
        // Double tconj, // tconj
        // Double tconj_error_min, // tconj_error_min
        // Double tconj_error_max, // tconj_error_max
        // Double tzero_tr, // tzero_tr
        // Double tzero_tr_error_min, // tzero_tr_error_min
        // Double tzero_tr_error_max, // tzero_tr_error_max
        // Double tzero_tr_sec, // tzero_tr_sec
        // Double tzero_tr_sec_error_min, // tzero_tr_sec_error_min
        // Double tzero_tr_sec_error_max, // tzero_tr_sec_error_max
        // Double lambda_angle, // lambda_angle
        // Double lambda_angle_error_min, // lambda_angle_error_min
        // Double lambda_angle_error_max, // lambda_angle_error_max
        // Double impact_parameter, // impact_parameter
        // Double impact_parameter_error_min, // impact_parameter_error_min
        // Double impact_parameter_error_max, // impact_parameter_error_max
        // Double tzero_vr, // tzero_vr
        // Double tzero_vr_error_min, // tzero_vr_error_min
        // Double tzero_vr_error_max, // tzero_vr_error_max
        Double k, // k
        // Double k_error_min, // k_error_min
        // Double k_error_max, // k_error_max
        Double temp_calculated, // temp_calculated
        // Double temp_calculated_error_min, // temp_calculated_error_min
        // Double temp_calculated_error_max, // temp_calculated_error_max
        Double temp_measured, // temp_measured
        // Double hot_point_lon, // hot_point_lon
        // Double geometric_albedo, // geometric_albedo
        // Double geometric_albedo_error_min, // geometric_albedo_error_min
        // Double geometric_albedo_error_max, // geometric_albedo_error_max
        // Double log_g, // log_g
        // String publication, // publication
        // String detection_type, // detection_type
        // String mass_measurement_type, // mass_measurement_type
        // String radius_measurement_type, // radius_measurement_type
        List<String> alternate_names, // alternate_names
        List<String> molecules, // molecules
        String star_name, // star_name
        Double ra, // ra
        Double dec, // dec
        Double mag_v, // mag_v
        // Double mag_i, // mag_i
        // Double mag_j, // mag_j
        // Double mag_h, // mag_h
        // Double mag_k, // mag_k
        Double star_distance, // star_distance
        // Double star_distance_error_min, // star_distance_error_min
        // Double star_distance_error_max, // star_distance_error_max
        Double star_metallicity, // star_metallicity
        // Double star_metallicity_error_min, // star_metallicity_error_min
        // Double star_metallicity_error_max, // star_metallicity_error_max
        Double star_mass, // star_mass
        // Double star_mass_error_min, // star_mass_error_min
        // Double star_mass_error_max, // star_mass_error_max
        Double star_radius, // star_radius
        // Double star_radius_error_min, // star_radius_error_min
        // Double star_radius_error_max, // star_radius_error_max
        // String star_sp_type, // star_sp_type
        Double star_age, // star_age
        // Double star_age_error_min, // star_age_error_min
        // Double star_age_error_max, // star_age_error_max
        // Double star_teff, // star_teff
        // Double star_teff_error_min, // star_teff_error_min
        // Double star_teff_error_max, // star_teff_error_max
        Boolean star_detected_disc, // star_detected_disc
        Boolean star_magnetic_field, // star_magnetic_field
        List<String> star_alternate_names // star_alternate_names
) {

    @Override
    public String toString() {
        String[] dataStrings = new String[] {
                ID.toString(),
                name != null ? name : "Unknown",
                planet_status != null ? planet_status : "Unknown",
                mass != null ? mass.toString() : "Unknown",
                radius != null ? radius.toString() : "Unknown",
                orbital_period != null ? orbital_period.toString() : "Unknown",
                semi_major_axis != null ? semi_major_axis.toString() : "Unknown",
                eccentricity != null ? eccentricity.toString() : "Unknown",
                inclination != null ? inclination.toString() : "Unknown",
                angular_distance != null ? angular_distance.toString() : "Unknown",
                discovered != null ? discovered.toString() : "Unknown",
                updated != null ? updated : "Unknown",
                omega != null ? omega.toString() : "Unknown",
                k != null ? k.toString() : "Unknown",
                temp_calculated != null ? temp_calculated.toString() : "Unknown",
                temp_measured != null ? temp_measured.toString() : "Unknow"
        };

        return String.join(Constants.SEPARATOR, dataStrings);
    }
}