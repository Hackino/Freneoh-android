package com.futuneotech.freneoh.features.feature_article.data.source.local.utils

import com.futuneotech.freneoh.core.data.utils.EntityMapper
import com.futuneotech.freneoh.features.feature_article.data.source.local.entity.ArticleEntity
import com.futuneotech.freneoh.features.feature_article.data.source.local.entity.MediaEntity
import com.futuneotech.freneoh.features.feature_article.data.source.local.entity.MediaMetaDataEntity
import com.futuneotech.freneoh.features.feature_article.domain.model.Article
import com.futuneotech.freneoh.features.feature_article.domain.model.Media
import com.futuneotech.freneoh.features.feature_article.domain.model.MediaMetaData
import javax.inject.Inject

class ArticleEntityMapper
@Inject constructor() : EntityMapper<ArticleEntity, Article> {
    override fun mapFromEntity(entity: ArticleEntity): Article {
        entity.apply {
            return Article(
                uri = uri,
                url = url,
                id = id,
                assetId =assetId,
                source = source,
                publishedDate = publishedDate,
                updated = updated,
                section = section,
                subsection = subsection,
                nytDSection = nytDSection,
                adxKeywords = adxKeywords,
                byLine = byLine,
                type = type,
                title = title,
                abstract = articleAbstract,
                descriptionFacet = descriptionFacet,
                organizationFacet = organizationFacet,
                personFacet = personFacet,
                geographicFacet = organizationFacet,
                media = ArrayList( media.map { mediaDto ->
                    Media(
                        type = mediaDto.type,
                        subtype = mediaDto.subtype,
                        caption = mediaDto.caption,
                        copyright = mediaDto.copyright,
                        approvedForSyndication = mediaDto.approvedForSyndication,
                        mediaMetaData = ArrayList(
                            mediaDto.mediaMetaData.map { mediaMetaDto ->
                                MediaMetaData(
                                    url = mediaMetaDto.url,
                                    format = mediaMetaDto.format,
                                    height = mediaMetaDto.height,
                                    width = mediaMetaDto.width
                                )
                            }
                        )
                    )
                })
            )
        }
    }

    override fun mapToEntity(domainModel: Article): ArticleEntity {
        domainModel.apply {
            return ArticleEntity(
                uri = uri,
                url = url,
                id = id,
                assetId =assetId,
                source = source,
                publishedDate = publishedDate,
                updated = updated,
                section = section,
                subsection = subsection,
                nytDSection = nytDSection,
                adxKeywords = adxKeywords,
                byLine = byLine,
                type = type,
                title = title,
                articleAbstract = abstract,
                descriptionFacet = descriptionFacet,
                organizationFacet = organizationFacet,
                personFacet = personFacet,
                geographicFacet = organizationFacet,
                media = ArrayList( media.map { media ->
                    MediaEntity(
                        type = media.type,
                        subtype = media.subtype,
                        caption = media.caption,
                        copyright = media.copyright,
                        approvedForSyndication = media.approvedForSyndication,
                        mediaMetaData = ArrayList(
                            media.mediaMetaData.map { mediaMeta ->
                                MediaMetaDataEntity(
                                    url = mediaMeta.url,
                                    format = mediaMeta.format,
                                    height = mediaMeta.height,
                                    width = mediaMeta.width
                                )
                            }
                        )
                    )
                })
            )
        }
    }

    fun mapFromEntityList(entities: List<ArticleEntity>): List<Article>{
        return entities.map { mapFromEntity(it) }
    }

}