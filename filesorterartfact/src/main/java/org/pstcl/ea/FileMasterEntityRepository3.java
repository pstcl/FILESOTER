package org.pstcl.ea;

import org.springframework.data.repository.PagingAndSortingRepository;

public interface FileMasterEntityRepository3 extends PagingAndSortingRepository<FileMaster3, Integer> {
	




}





























//	@Override
//    @RestResource(exported = false)
//    public List<ScadaDataEntity> findAll();
//	


//	@RestResource(exported = false)
//    @Query(value="select entity from ScadaDataEntity entity where entity.entityId.dateS >= :dateS")
//    List<ScadaDataEntity> findAllWithdateS(@Param("dateS") LocalDate dateS);
//@DateTimeFormat(pattern="yyyy-MM-dd")@Param("dateS")


//	@RestResource(exported = false)
//    @Query("select entity from ScadaDataEntity entity where entity.entityId.dateS >= :dateS")
//    List<ScadaDataEntity> findAllWithdateS(
//    		@DateTimeFormat(pattern="yyyy-MM-dd")    		@Param("dateS") LocalDate dateS);
//	

//  



//
//	@RestResource(exported = false)
//	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = '*/Rate=10'")
//	List<ScadaDataEntity> findAllWithFrequency(@Param("limit") int limit);
//
//
//	@RestResource(exported = false)
//	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.line.pseb_drwl.mw/rate=10' ")
//	List <ScadaDataEntity> findAllDrawal(@Param("limit") int limit);
//
//	@RestResource(exported = false)
//	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.shdl.pseb_s.mw/rate=10' ")
//	List <ScadaDataEntity> findAllSchedule(@Param("limit") int limit);
//
//	@RestResource(exported = false)
//	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.line.pseb_od_ud.mw/rate=10' ")
//	List <ScadaDataEntity> findAllOD_UD(@Param("limit") int limit);
//
//	@RestResource(exported = false)
//	@Query(value="SELECT entity from ScadaDataEntity entity where entity.entityId.ddeItem = 'nrldc_pg.ld.pseb_load.mw/rate=10' ")
//	List <ScadaDataEntity> findAllLoad(@Param("limit") int limit);
//}
