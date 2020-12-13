--ALTER TABLE candidate
--RENAME  candidate_id To id_candidate ;
--ALTER TABLE skills
--RENAME  skills_id TO id_skills ;
ALTER TABLE candidate
ADD reference_number INTEGER;